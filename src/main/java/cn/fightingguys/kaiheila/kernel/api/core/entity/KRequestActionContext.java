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

package cn.fightingguys.kaiheila.kernel.api.core.entity;

import cn.fightingguys.kaiheila.kernel.api.action.KRequestAction;
import cn.fightingguys.kaiheila.kernel.api.auth.KAuthType;
import cn.fightingguys.kaiheila.kernel.api.core.KApiBase;
import cn.fightingguys.kaiheila.kernel.api.core.KEApiVersion;
import cn.fightingguys.kaiheila.kernel.api.ratelimit.KRateLimiterPriority;
import cn.fightingguys.kaiheila.kernel.http.KHttpClient;
import cn.fightingguys.kaiheila.kernel.http.entity.KRequestEntity;
import cn.fightingguys.kaiheila.kernel.http.entity.KResponseEntity;

/**
 * 请求动作上下文
 */
public final class KRequestActionContext {

    private final KRateLimiterPriority priority;
    private final Class<? extends KHttpClient> httpClientClass;
    private final KRequestEntity requestEntity = new KRequestEntity();
    private final KResponseEntity responseEntity = new KResponseEntity();
    private KHttpClient httpClient = null;

    public KRequestActionContext(KRequestAction action, KEApiVersion apiVersion, String token, KRateLimiterPriority priority, Class<? extends KHttpClient> httpClientClass) {
        requestEntity.setRequestUrl(concatApiBaseUrl(apiVersion, action.getHttpPath()));
        requestEntity.setMethod(action.getHttpMethod());
        requestEntity.setBody(action.getBody());

        action.getParams().forEach(requestEntity::param);

        requestEntity.header(KApiBase.contextType, KApiBase.contextTypeJson);
        requestEntity.header(KApiBase.authorization, KAuthType.BOT.getType() + " " + token);

        // todo 日志后续需要删除替换
        System.out.println(
                requestEntity
        );

        this.priority = priority;
        this.httpClientClass = httpClientClass;
    }

    public void send() {
        try {
            httpClient = httpClientClass.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            // todo 类不存在创建失败
            e.printStackTrace();
            return;
        }
        httpClient.url(requestEntity.getRequestUrl());
        httpClient.method(requestEntity.getMethod());
        httpClient.body(requestEntity.getBody());
        httpClient.param(requestEntity.getParams());
        httpClient.header(requestEntity.getHeader());
        httpClient.send();
        receive();
    }

    private void receive() {
        if (httpClient.fatalError()) {
            responseEntity.fatalError();
        }
        responseEntity.setCode(httpClient.getStatusCode());
        responseEntity.setBody(httpClient.getBody());
        responseEntity.setHeader(httpClient.getHeader());
        responseEntity.setErrorMessage(httpClient.getErrorMessage());
    }

    private String concatApiBaseUrl(KEApiVersion apiVersion, String path) {
        String version = "v" + apiVersion.getVersion();
        if (path.charAt(0) != '/') {
            return KApiBase.baseUrl + "/" + version + "/" + path;
        } else {
            return KApiBase.baseUrl + "/" + version + path;
        }
    }

    public KRateLimiterPriority getPriority() {
        return priority;
    }

    public KResponseEntity getResponseEntity() {
        return responseEntity;
    }

}
