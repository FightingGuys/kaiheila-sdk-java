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

package cn.fightingguys.kaiheila.client.profile;

import cn.fightingguys.kaiheila.client.SourceClientType;

public class KhlProfile {

    private final SourceClientType sourceClientType;

    private final String clientId;

    private final String clientSecret;

    private final String token;

    private final String verifyToken;

    private final String encryptKey;

    private KhlProfile(SourceClientType sourceClientType, String clientId, String clientSecret, String token, String verifyToken, String encryptKey) {
        this.sourceClientType = sourceClientType;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.token = token;
        this.verifyToken = verifyToken;
        this.encryptKey = encryptKey;
    }

    public static Builder Builder() {
        return new Builder();
    }

    public SourceClientType getSourceClientType() {
        return sourceClientType;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
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

    public static class Builder {

        private SourceClientType sourceClientType;
        private String clientId;
        private String clientSecret;
        private String token;
        private String verifyToken;
        private String encryptKey;

        public Builder sourceClientType(SourceClientType sourceClientType) {
            this.sourceClientType = sourceClientType;
            return this;
        }

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
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

        public KhlProfile create() {
            return new KhlProfile(sourceClientType, clientId, clientSecret, token, verifyToken, encryptKey);
        }
    }
}
