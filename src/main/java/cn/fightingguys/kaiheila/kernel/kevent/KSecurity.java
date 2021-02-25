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

package cn.fightingguys.kaiheila.kernel.kevent;

import cn.fightingguys.kaiheila.kernel.kevent.entity.KEncryptEntity;
import cn.fightingguys.kaiheila.kernel.kevent.entity.KEventMetaDataEntity;
import com.google.gson.Gson;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public final class KSecurity {

    /**
     * 加密密钥
     *
     * @link https://developer.kaiheila.cn/doc/webhook#%E6%B6%88%E6%81%AF%E8%A7%A3%E5%AF%86
     */
    private final String encryptKey;

    /**
     * webhook 模式独有，验证密钥
     *
     * @link https://developer.kaiheila.cn/doc/webhook#%E6%8E%A5%E6%94%B6%E5%B9%B6%E5%93%8D%E5%BA%94%E4%BA%8B%E4%BB%B6
     */
    private final String verifyToken;

    /**
     * 数据解密密钥。消息验证密钥
     *
     * @param encryptKey  解密密钥
     * @param verifyToken 消息真伪密钥
     */
    public KSecurity(String encryptKey, String verifyToken) {
        this.encryptKey = encryptKey;
        this.verifyToken = verifyToken;
    }

    /**
     * 验证消息与用户预设密文是否正确
     *
     * @param eventMetaData 事件消息元数据
     * @return 条件成立则为 true 相反则 false
     */
    public boolean verify(KEventMetaDataEntity eventMetaData) {
        String dataVerifyToken = eventMetaData.getVerifyToken();
        return this.verifyToken.equals(dataVerifyToken);
    }

    public class AesCipher {

        /**
         * AES-256-CBC 密钥长度要求
         */
        private static final int SECRET_KEY_LENGTH = 32;
        private static final int INIT_VECTOR_LENGTH = 16;
        /**
         * 转储加密字节数组
         */
        private byte[] encryptData;

        /**
         * 检查是否存在加密字符串
         *
         * @param data 需检测字节数组
         * @return 存在加密信息
         */
        public boolean isEncryptData(byte[] data) {
            KEncryptEntity entity = new Gson().fromJson(new String(data, StandardCharsets.UTF_8), KEncryptEntity.class);
            String encrypt = entity.getEncrypt();
            if (encrypt != null) {
                encryptData = encrypt.getBytes(StandardCharsets.UTF_8);
            }
            return encrypt != null;
        }

        public byte[] getEncryptData() {
            return encryptData;
        }

        public byte[] decrypt(byte[] data) throws Throwable {
            return decrypt(KSecurity.this.encryptKey, data);
        }

        /**
         * 通过AES-128-CBC算法加密文本
         * <p>
         * 通过 PKCS5 方式进行填充内容，不足长度的密钥{@code secretKey}将通过后面补 0x00 达到长度。
         * </p>
         *
         * @param secretKey Encrypt Key 密钥
         * @param plainText 需要加密的原文
         * @return 加密结果
         */
        public String encrypt(String secretKey, byte[] plainText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyException, BadPaddingException, IllegalBlockSizeException {
            byte[] byteSecretKey = setValidSecretKeyLength(secretKey);
            SecureRandom secureRandom = new SecureRandom();
            byte[] iv = new byte[SECRET_KEY_LENGTH];
            secureRandom.nextBytes(iv);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeySpec secretKeySpec = new SecretKeySpec(byteSecretKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(plainText);
            ByteBuffer byteBuffer = ByteBuffer.allocate(iv.length + encrypted.length);
            byteBuffer.put(iv);
            byteBuffer.put(encrypted);
            return Base64.getEncoder().encodeToString(byteBuffer.array());
        }

        /**
         * 通过AES-128-CBC算法解密文本
         * <p>
         * 通过 PKCS5 方式进行填充内容，不足长度的密钥将通过后面补 0x00 达到长度。
         * </p>
         *
         * @param secretKey  Encrypt Key 密钥
         * @param cipherText 需要加密的原文
         * @return 解密结果
         */
        public byte[] decrypt(String secretKey, byte[] cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyException, BadPaddingException, IllegalBlockSizeException {
            byte[] byteSecretKey = setValidSecretKeyLength(secretKey);
            byte[] sourceEncrypted = Base64.getDecoder().decode(cipherText);
            byte[] dataEncrypted = Base64.getDecoder().decode(Arrays.copyOfRange(sourceEncrypted, INIT_VECTOR_LENGTH, sourceEncrypted.length));
            IvParameterSpec ivParameterSpec = new IvParameterSpec(sourceEncrypted, 0, INIT_VECTOR_LENGTH);
            SecretKeySpec secretKeySpec = new SecretKeySpec(byteSecretKey, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(dataEncrypted);
        }

        /**
         * 设置正确密钥长度
         *
         * @param key 需检查的密钥
         * @return 正确字节数组
         */
        private byte[] setValidSecretKeyLength(String key) throws KeyException {
            int sourceKeyLength = key.length();
            if (sourceKeyLength == 0) {
                throw new KeyException("Empty Secret Key");
            } else if (sourceKeyLength <= SECRET_KEY_LENGTH) {
                byte[] result = new byte[SECRET_KEY_LENGTH];
                byte[] source = key.getBytes(StandardCharsets.UTF_8);
                System.arraycopy(source, 0, result, 0, sourceKeyLength);
                return result;
            } else {
                int rv = sourceKeyLength - SECRET_KEY_LENGTH;
                return key.substring(0, key.length() + rv).getBytes(StandardCharsets.UTF_8);
            }
        }

    }
}
