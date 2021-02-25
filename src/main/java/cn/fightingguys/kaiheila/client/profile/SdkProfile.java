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

import cn.fightingguys.kaiheila.kernel.http.KHttpClient;
import cn.fightingguys.kaiheila.kernel.http.KHttpClientType;
import cn.fightingguys.kaiheila.kernel.http.impl.KJavaNativeHttpClientImpl;
import cn.fightingguys.kaiheila.kernel.websocket.KWebSocketClient;
import cn.fightingguys.kaiheila.kernel.websocket.KWebSocketClientType;
import cn.fightingguys.kaiheila.kernel.websocket.impl.KJavaNativeWebSocketClientEndpoint;

public class SdkProfile {

    private final Class<? extends KHttpClient> httpClientClass;

    private final Class<? extends KWebSocketClient> webSocketClientClass;

    // todo 消息接口绑定函数


    private SdkProfile(Class<? extends KHttpClient> httpClientClass, Class<? extends KWebSocketClient> webSocketClientClass) {
        this.httpClientClass = httpClientClass;
        this.webSocketClientClass = webSocketClientClass;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Class<? extends KHttpClient> getHttpClientClass() {
        return httpClientClass;
    }

    public Class<? extends KWebSocketClient> getWebSocketClientClass() {
        return webSocketClientClass;
    }

    public static class Builder {

        private Class<? extends KHttpClient> httpClientClass;
        private Class<? extends KWebSocketClient> webSocketClientClass;

        public static SdkProfile createDefault() {
            return new SdkProfile(KJavaNativeHttpClientImpl.class, KJavaNativeWebSocketClientEndpoint.class);
        }

        public Builder httpClientClass(Class<? extends KHttpClient> httpClientClass) {
            this.httpClientClass = httpClientClass;
            return this;
        }

        public Builder httpClientClassType(KHttpClientType kHttpClientType) {
            this.httpClientClass = kHttpClientType.getClazz();
            return this;
        }

        public Builder webSocketClientClass(Class<? extends KWebSocketClient> webSocketClientClass) {
            this.webSocketClientClass = webSocketClientClass;
            return this;
        }

        public Builder webSocketClientClassType(KWebSocketClientType webSocketClientType) {
            this.webSocketClientClass = webSocketClientType.getClazz();
            return this;
        }

        public SdkProfile create() {

            if (httpClientClass == null) {
                httpClientClass = KJavaNativeHttpClientImpl.class;
            }

            if (webSocketClientClass == null) {
                webSocketClientClass = KJavaNativeWebSocketClientEndpoint.class;
            }

            return new SdkProfile(httpClientClass, webSocketClientClass);
        }
    }

}
