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

package cn.fightingguys.kaiheila;

import cn.fightingguys.kaiheila.api.core.KHLRestApiService;
import cn.fightingguys.kaiheila.api.domain.RemoteURL;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import okio.ByteString;
import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class OkHttpWebSocketTests {

    public static volatile WebSocket websocket = null;

    @Test
    public void websocketTest() throws KHLAPIServiceException, InterruptedException {
        OkHttpClient client = new OkHttpClient.Builder().build();
        KHLRestApiService service = ApiServiceTests.getServiceInstance();
        RemoteURL webSocketGateway = service.getGatewayService().getWebSocketGateway(0);
        Request request = new Request.Builder().get().url(webSocketGateway.getUrl()).build();
        websocket = client.newWebSocket(request, new OkHttp3WebSocketListener());
        while (true) {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
//            System.out.println("Main Thread" + Thread.currentThread().getName() + "#" +Thread.currentThread().getId());
            Thread.sleep(Long.MAX_VALUE);
        }
    }

    static class OkHttp3WebSocketListener extends WebSocketListener {

        private boolean ifFirst = true;
        public final static Object lock = new Object();
        public volatile static String sn = "0";

        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
        }

        @Override
        public void onMessage(WebSocket webSocket, String text) {
            super.onMessage(webSocket, text);
            if (ifFirst) {
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new PingTimerTask(), TimeUnit.SECONDS.toMillis(28), TimeUnit.SECONDS.toMillis(28));
            }
            ifFirst = false;
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = null;
            try {
                jsonNode = mapper.readTree(text);
            } catch (JsonProcessingException e) {
            }
//            System.out.println(text);
            String sn = jsonNode.path("sn").asText();
            if (sn.length() != 0) {
                synchronized (lock) {
                    OkHttp3WebSocketListener.sn = sn;
                }
            }
            String context = jsonNode.path("d").path("content").asText();
            System.out.println("收到新消息 " + context);
        }

        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            super.onMessage(webSocket, bytes);
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            super.onClosing(webSocket, code, reason);
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            super.onClosed(webSocket, code, reason);
            System.out.println("onClosed" + reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            super.onFailure(webSocket, t, response);
            System.out.println("onFailure" + response);
            System.err.println(t.getMessage());
        }

        static class PingTimerTask extends TimerTask {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("发ping包给开黑啦 sn:" + OkHttp3WebSocketListener.sn);
                    OkHttpWebSocketTests.websocket.send("{\"s\":2, \"sn\":" + OkHttp3WebSocketListener.sn + "}");
                }
            }
        }
    }
}

