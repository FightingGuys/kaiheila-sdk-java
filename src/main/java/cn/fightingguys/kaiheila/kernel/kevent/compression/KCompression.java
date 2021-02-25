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

package cn.fightingguys.kaiheila.kernel.kevent.compression;

public interface KCompression {

    /**
     * 检测符合数据格式
     *
     * @param zData 压缩数据字节数组
     * @return 符合数据格式
     */
    boolean checkValidFormat(byte[] zData);

    /**
     * 解压数据接口
     *
     * @param data 压缩数据字节数组
     * @return 解压后字节数组
     * @throws Exception 抛出异常
     */
    byte[] decompress(byte[] data) throws Exception;

}
