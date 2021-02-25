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

package cn.fightingguys.kaiheila.kernel.oauth2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * OAuth2 网站认证模式链接 或 机器人邀请链接 生成器
 */
public final class KOAuth2UriGenerator {
    protected final static String AUTHORIZE_URL = "https://kaiheila.cn/app/oauth2/authorize";
    protected final static String CLIENT_ID = "client_id";
    protected final static String REDIRECT_URI = "redirect_uri";
    protected final static String PERMISSIONS = "permissions";
    protected final static String SCOPE = "scope";
    private final Map<String, String> params = new TreeMap<>();
    private boolean bUrlEncoding;

    private String urlEncoding(String param) {
        try {
            return URLEncoder.encode(param, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    /**
     * 生成机器人邀请链接
     *
     * @return 相应 OAuth2 链接
     */
    public String generate() {
        StringBuilder builder = new StringBuilder(AUTHORIZE_URL);
        boolean bFirstParam = true;
        for (String key : params.keySet()) {
            if (!bFirstParam) {
                builder.append('&');
            } else {
                builder.append('?');
                bFirstParam = false;
            }
            builder.append(key);
            builder.append('=');
            if (bUrlEncoding) {
                builder.append(urlEncoding(params.get(key)));
            } else {
                builder.append(params.get(key));
            }
        }
        return builder.toString();
    }

    /**
     * OAuth2 链接建筑者
     * 可以创建 网站认证模式 与 机器人邀请链接
     */
    public static class Builder {
        private final KOAuth2UriGenerator generate = new KOAuth2UriGenerator();
        private final Set<KOAuth2ScopeType> scopes = new TreeSet<>();

        public Builder() {
        }

        public Builder clientId(String clientId) {
            this.generate.params.put(CLIENT_ID, clientId);
            return this;
        }

        public Builder redirectUri(String uri) {
            this.generate.params.put(REDIRECT_URI, uri);
            return this;
        }

        /**
         * 添加相应权限
         * 如果存在重复权限，权限将会处于启用状态
         *
         * @param scope 相应权限
         * @return 当前Builder实例
         * @see KOAuth2ScopeType
         */
        public Builder scope(KOAuth2ScopeType scope) {
            // todo 网站OAuth2身份认证模式 与 机器人认证模式
            StringBuilder builder = new StringBuilder();
            scopes.add(scope);
            scopes.forEach(s -> {
                builder.append('+');
                builder.append(s.getValue());
            });
            String scopeString = builder.substring(1);
            this.generate.params.put(SCOPE, scopeString);
            return this;
        }

        /**
         * 启用将使用 Java 默认字符集转码相关字符
         *
         * @param bUrlEncoding 若使用传入 布尔值 true，否则生成链接将不转码
         * @return 当前Builder实例
         */
        public Builder urlEncoding(boolean bUrlEncoding) {
            this.generate.bUrlEncoding = bUrlEncoding;
            return this;
        }

        /**
         * Bot 权限对象
         *
         * @param userPermission Bot权限对象
         * @return 当前Builder实例
         */
        public Builder botPermission(KUserPermission userPermission) {
            long permission = userPermission.getPermissionNumber();
            this.generate.params.put(PERMISSIONS, String.valueOf(permission));
            return this;
        }

        /**
         * 构建 OAuth2 链接生成器
         *
         * @return OAuth2UriGenerator对象
         */
        public KOAuth2UriGenerator build() {
            return this.generate;
        }
    }
}
