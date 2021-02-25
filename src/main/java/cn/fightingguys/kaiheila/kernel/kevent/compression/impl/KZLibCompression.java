/*
 *    Copyright 2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package cn.fightingguys.kaiheila.kernel.kevent.compression.impl;

import cn.fightingguys.kaiheila.kernel.kevent.compression.KCompression;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class KZLibCompression implements KCompression {
    private static final int DEFAULT_BUFFER_SIZE = 8192; /* 8 kb size */

    /**
     * 检查数据是否正确格式，数据含有特定魔术字则为正确格式
     * <code>
     * 0x78 0x01
     * 0x78 0x5E
     * 0x78 0x9C
     * 0x78 0xDA
     * </code>
     *
     * @param zData 输入压缩字节数组
     * @return 数据格式为ZLib格式
     */
    public boolean checkValidFormat(byte[] zData) {
        return ((zData[0] ^ (byte) 0x78) == 0) && ((zData[1] ^ (byte) 0x01) == 0 || (zData[1] ^ (byte) 0x5E) == 0 || (zData[1] ^ (byte) 0x9C) == 0 || (zData[1] ^ (byte) 0xDA) == 0);
    }

    /**
     * 解压Zlib格式压缩字节数组
     *
     * @param data 压缩数据字节数组
     * @return 解压后字节数组
     * @throws IOException         IO流问题
     * @throws DataFormatException 解压格式问题
     */
    public byte[] decompress(byte[] data) throws IOException, DataFormatException {
        // todo {class Inflater} 无法处理坏数据考虑替换
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        int currentTotalWriteBytes = 0;
        int iRetryCount = 5; // 5次机会，坏数据计数器
        while (!inflater.finished()) {
            byte[] tmp = new byte[DEFAULT_BUFFER_SIZE];
            int currentWriteBytes = inflater.inflate(tmp);
            arrayOutputStream.write(tmp, currentTotalWriteBytes, currentWriteBytes);
            currentTotalWriteBytes += currentWriteBytes;
            if (currentWriteBytes == 0) {
                if (--iRetryCount == 0)
                    break;
            }
        }
        inflater.end();
        arrayOutputStream.close();
        if (iRetryCount == 0) { // 坏数据失去机会
            throw new EOFException("The compress data end of file mark is lost");
        }
        return arrayOutputStream.toByteArray();
    }

}
