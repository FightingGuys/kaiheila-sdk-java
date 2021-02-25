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

package cn.fightingguys.kaiheila.kernel.api.core;

import cn.fightingguys.kaiheila.kernel.api.action.KIRequestAction;
import cn.fightingguys.kaiheila.kernel.api.action.KRequestAction;
import cn.fightingguys.kaiheila.kernel.api.core.entity.KRequestActionContext;
import cn.fightingguys.kaiheila.kernel.api.ratelimit.KRateLimiterPriority;
import cn.fightingguys.kaiheila.kernel.config.KConfiguration;
import cn.fightingguys.kaiheila.kernel.http.KHttpClient;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Rest API 处理核心
 */
// todo Global RateLimiter
public final class KRestCore {

    private final KConfiguration configuration;
    private final KEApiVersion apiVersion;
    private final ConcurrentLinkedQueue<KRequestActionContext> queueEntities = new ConcurrentLinkedQueue<>();
    private final Class<? extends KHttpClient> httpClientClass;

    public KRestCore(KConfiguration configuration, KEApiVersion apiVersion, Class<? extends KHttpClient> httpClientClass) {
        this.configuration = configuration;
        this.apiVersion = apiVersion;
        this.httpClientClass = httpClientClass;
    }


    /**
     * @param action
     */
    public void request(KIRequestAction action) {
        request(action, KRateLimiterPriority.NORMAL);
    }


    /**
     * @param action
     * @param priority
     */
    public void request(KIRequestAction action, KRateLimiterPriority priority) {
        KRequestAction request = action.createRequest();
        String token = configuration.getToken();
        queueEntities.add(new KRequestActionContext(request, apiVersion, token, priority, httpClientClass));
        send(); // todo 单线程临时发送
    }


    /**
     * 发送消息
     */
    private void send() {
        KRequestActionContext entity = queueEntities.poll();
        if (entity != null) {
            entity.send();
            // todo 日志后续需要删除替换
            System.out.println(
                entity.getResponseEntity()
            );
        }
    }

}
