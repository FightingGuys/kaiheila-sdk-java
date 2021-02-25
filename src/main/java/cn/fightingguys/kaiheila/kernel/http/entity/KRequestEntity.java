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

package cn.fightingguys.kaiheila.kernel.http.entity;

import cn.fightingguys.kaiheila.kernel.http.KHttpMethod;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Http 请求结果实体类
 */
public final class KRequestEntity {

    private final Map<String, String> header = new HashMap<>();
    private final Map<String, String> params = new HashMap<>();
    private KHttpMethod method;
    private int timeout;
    private String requestUrl;
    /* Only Post or Put Method Active */
    private String body;

    public KRequestEntity header(String key, String value) {
        header.put(key, value);
        return this;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public KHttpMethod getMethod() {
        return method;
    }

    public void setMethod(KHttpMethod method) {
        this.method = method;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void param(String key, String value) {
        params.put(key, value);
    }

    public String getQueryString() {
        StringBuilder builder = new StringBuilder();
        params.forEach((k, v) -> {
            builder.append('&');
            String key = null, value = null;
            try {
                key = URLEncoder.encode(k, StandardCharsets.UTF_8.name());
                value = URLEncoder.encode(k, StandardCharsets.UTF_8.name());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            builder.append(key).append("=").append(value);
        });
        builder.delete(0, 1);
        return builder.toString();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "KRequestEntity{" +
                "header=" + header +
                ", params=" + params +
                ", method=" + method +
                ", timeout=" + timeout +
                ", requestUrl='" + requestUrl + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
