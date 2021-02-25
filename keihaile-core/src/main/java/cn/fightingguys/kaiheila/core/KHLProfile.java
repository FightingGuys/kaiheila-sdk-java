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

package cn.fightingguys.kaiheila.core;

import java.util.Locale;

public class KHLProfile {

    private final String appId;

    private final String appSecret;

    private final String token;

    private final String verifyToken;

    private final String encryptKey;

    private final Locale language;

    private KHLProfile(String appId, String appSecret, String token, String verifyToken, String encryptKey, Locale language) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.token = token;
        this.verifyToken = verifyToken;
        this.encryptKey = encryptKey;
        this.language = (language != null) ? language : Locale.getDefault();
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getToken() {
        return token;
    }

    public String getVerifyToken() {
        return verifyToken;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public Locale getLanguage() {
        return language;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String appId;
        private String appSecret;
        private String token;
        private String verifyToken;
        private String encryptKey;
        private Locale language;

        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public Builder appSecret(String appSecret) {
            this.appSecret = appSecret;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder verifyToken(String verifyToken) {
            this.verifyToken = verifyToken;
            return this;
        }

        public Builder encryptKey(String encryptKey) {
            this.encryptKey = encryptKey;
            return this;
        }

        public Builder language(Locale language) {
            this.language = language;
            return this;
        }

        public KHLProfile build() {
            return new KHLProfile(appId, appSecret, token, verifyToken, encryptKey, language);
        }
    }

}
