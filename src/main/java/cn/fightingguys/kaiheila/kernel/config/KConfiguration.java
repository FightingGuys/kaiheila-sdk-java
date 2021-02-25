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

package cn.fightingguys.kaiheila.kernel.config;

public final class KConfiguration {

    private boolean webhookMode;

    private String clientId;

    private String clientSecret;

    private String token;

    private String verifyToken;

    private String encryptKey;

    private boolean serverlessMode;

    public boolean isWebhookMode() {
        return webhookMode;
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

    /**
     * Webhook 连接方式
     */
    public final static class WebhookBuilder {

        private final KConfiguration configuration = new KConfiguration();

        public WebhookBuilder clientId(String clientId) {
            configuration.clientId = clientId;
            return this;
        }

        public WebhookBuilder clientSecret(String clientSecret) {
            configuration.clientSecret = clientSecret;
            return this;
        }

        public WebhookBuilder token(String token) {
            configuration.token = token;
            return this;
        }

        public WebhookBuilder verifyToken(String verifyToken) {
            configuration.verifyToken = verifyToken;
            return this;
        }

        public WebhookBuilder encryptKey(String encryptKey) {
            configuration.encryptKey = encryptKey;
            return this;
        }

        public WebhookBuilder serverlessMode(boolean serverless) {
            configuration.serverlessMode = serverless;
            return this;
        }

        public KConfiguration build() {
            configuration.webhookMode = true;
            return configuration;
        }

    }

    /**
     * WebSocket 连接方式
     */
    public final static class WebSocketBuilder {

        private final KConfiguration configuration = new KConfiguration();

        public WebSocketBuilder clientId(String clientId) {
            configuration.clientId = clientId;
            return this;
        }

        public WebSocketBuilder clientSecret(String clientSecret) {
            configuration.clientSecret = clientSecret;
            return this;
        }

        public WebSocketBuilder token(String token) {
            configuration.token = token;
            return this;
        }

        public KConfiguration build() {
            configuration.webhookMode = false;
            return configuration;
        }

    }

    /**
     * 自定义配置，不推荐使用
     */
    public final static class CustomBuilder {

        private final KConfiguration configuration = new KConfiguration();

        public CustomBuilder webhookMode(boolean isOn) {
            configuration.webhookMode = isOn;
            return this;
        }

        public CustomBuilder clientId(String clientId) {
            configuration.clientId = clientId;
            return this;
        }

        public CustomBuilder clientSecret(String clientSecret) {
            configuration.clientSecret = clientSecret;
            return this;
        }

        public CustomBuilder token(String token) {
            configuration.token = token;
            return this;
        }

        public CustomBuilder verifyToken(String verifyToken) {
            configuration.verifyToken = verifyToken;
            return this;
        }

        public CustomBuilder encryptKey(String encryptKey) {
            configuration.encryptKey = encryptKey;
            return this;
        }

        public KConfiguration build() {
            return configuration;
        }

    }
}
