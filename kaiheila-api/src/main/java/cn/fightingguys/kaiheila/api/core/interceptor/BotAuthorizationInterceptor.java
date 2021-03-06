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

package cn.fightingguys.kaiheila.api.core.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * <p>
 * 机器人身份鉴权拦截器
 * </p>
 * <p>
 * Http Authorization <a herf="https://tools.ietf.org/html/rfc7235">rfc7235</a>
 *
 * @link https://developer.kaiheila.cn/doc/reference#%E5%B8%B8%E8%A7%84%20http%20%E6%8E%A5%E5%8F%A3%E8%A7%84%E8%8C%83
 */
public class BotAuthorizationInterceptor implements Interceptor {
    private final String token;

    /**
     * 创建机器人身份鉴权拦截器
     *
     * @param token 开发者中心创建机器人时生成的token
     */
    public BotAuthorizationInterceptor(String token) {
        this.token = token;
    }

    /**
     * 触发拦截器
     *
     * @param chain {@link Interceptor.Chain}
     * @return 开黑啦服务器返回的鉴权信息 {@link Response}
     * @throws IOException
     */
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request fixedRequest = originalRequest.newBuilder()
                .header("Authorization", "Bot " + token)
                .build();
        return chain.proceed(fixedRequest);
    }
}
