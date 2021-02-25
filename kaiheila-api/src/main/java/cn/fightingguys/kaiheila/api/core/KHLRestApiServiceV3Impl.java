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

package cn.fightingguys.kaiheila.api.core;

import cn.fightingguys.kaiheila.api.core.interceptor.BotAuthorizationInterceptor;
import cn.fightingguys.kaiheila.api.core.interceptor.LanguageInterceptor;
import cn.fightingguys.kaiheila.api.core.request.RestRequestService;
import cn.fightingguys.kaiheila.api.service.*;
import cn.fightingguys.kaiheila.core.KHLProfile;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import okhttp3.OkHttpClient;

/**
 * 开黑啦 Http API请求服务 第三版
 *
 * @link https://developer.kaiheila.cn/doc/reference
 */
public class KHLRestApiServiceV3Impl implements KHLRestApiService {

    private final AssetService assetService;
    private final ChannelService channelService;
    private final GatewayService gatewayService;
    private final GuildEmoji guildEmoji;
    private final GuildService guildService;
    private final IntimacyService intimacyService;
    private final MessageService messageService;
    private final GuildRoleService guildRoleService;
    private final UserChatService userChatService;
    private final UserService userService;

    /**
     * 创建 API 服务，使用默认配置 OkHttp 客户端
     *
     * @param khlProfile {@link KHLProfile} 参数
     * @see KHLRestApiServiceV3Impl#withDefaultClient(KHLProfile)
     */
    public KHLRestApiServiceV3Impl(KHLProfile khlProfile) {
        this(khlProfile, withDefaultClient(khlProfile), new ObjectMapper());
    }

    /**
     * 构建 API 模块服务
     *
     * @param khlProfile {@link KHLProfile} 参数
     * @param client     {@link OkHttpClient}
     * @param mapper     {@link ObjectMapper}
     */
    public KHLRestApiServiceV3Impl(KHLProfile khlProfile, OkHttpClient client, ObjectMapper mapper) {

        configureDefaultJacksonObjectMapper(mapper);
        RestRequestService requestService = RestRequestService.createRequestTemplate(KHLRestApiService.API_ENDPOINT_BASE_URL, client, mapper);

        this.assetService = requestService.createRestService(AssetService.class);
        this.channelService = requestService.createRestService(ChannelService.class);
        this.gatewayService = requestService.createRestService(GatewayService.class);
        this.guildEmoji = requestService.createRestService(GuildEmoji.class);
        this.guildService = requestService.createRestService(GuildService.class);
        this.intimacyService = requestService.createRestService(IntimacyService.class);
        this.messageService = requestService.createRestService(MessageService.class);
        this.guildRoleService = requestService.createRestService(GuildRoleService.class);
        this.userChatService = requestService.createRestService(UserChatService.class);
        this.userService = requestService.createRestService(UserService.class);
    }

    /**
     * 构建适用于当前 API 模块的默认配置 OkHttp3 客户端
     *
     * @param khlProfile {@link KHLProfile}
     * @return 默认配置 OkHttp3 客户端实例
     */
    private static OkHttpClient withDefaultClient(KHLProfile khlProfile) {
        return new OkHttpClient.Builder()
                .addInterceptor(new BotAuthorizationInterceptor(khlProfile.getToken()))
                .addInterceptor(new LanguageInterceptor(khlProfile.getLanguage()))
//                .addInterceptor(new PageableInterceptor())
//                .addInterceptor(new RateLimitOkHttpInterceptor())
                .build();
    }

    /**
     * 修改只用于当前 API 模块的默认 Jackson-databind 配置
     *
     * @param mapper {@link ObjectMapper}
     */
    private static void configureDefaultJacksonObjectMapper(ObjectMapper mapper) {
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 获取媒体服务
     *
     * @return {@link AssetService} 媒体服务
     * @link https://developer.kaiheila.cn/doc/http/asset
     */
    public AssetService getAssetService() {
        return this.assetService;
    }

    /**
     * 获取频道服务
     *
     * @return {@link ChannelService} 频道服务
     * @link https://developer.kaiheila.cn/doc/http/channel
     */
    public ChannelService getChannelService() {
        return this.channelService;
    }

    /**
     * 获取 WebSocket 接口 Gateway 服务
     *
     * @return {@link GatewayService} Gateway服务
     * @link https://developer.kaiheila.cn/doc/http/gateway
     */
    public GatewayService getGatewayService() {
        return this.gatewayService;
    }

    /**
     * 获取服务器表情服务
     *
     * @return {@link GuildEmoji} 服务器表情服务
     * @link https://developer.kaiheila.cn/doc/http/guild-emoji
     */
    public GuildEmoji getGuildEmoji() {
        return this.guildEmoji;
    }

    /**
     * 获取服务器服务
     *
     * @return {@link GuildService} 服务器服务
     * @link https://developer.kaiheila.cn/doc/http/guild
     */
    public GuildService getGuildService() {
        return this.guildService;
    }

    /**
     * 获取亲密度服务
     *
     * @return {@link IntimacyService} 亲密度服务
     * @link https://developer.kaiheila.cn/doc/http/intimacy
     */
    public IntimacyService getIntimacyService() {
        return this.intimacyService;
    }

    /**
     * 获取频道消息服务
     *
     * @return {@link MessageService} 频道消息服务
     * @link https://developer.kaiheila.cn/doc/http/message
     */
    public MessageService getMessageService() {
        return this.messageService;
    }

    /**
     * 获取角色服务
     *
     * @return {@link GuildRoleService} 服务器角色服务
     * @link https://developer.kaiheila.cn/doc/http/guild-role
     */
    public GuildRoleService getGuildRoleService() {
        return this.guildRoleService;
    }

    /**
     * 获取私聊服务
     *
     * @return {@link UserChatService} 私聊服务
     * @link https://developer.kaiheila.cn/doc/http/user-chat
     */
    public UserChatService getUserChat() {
        return this.userChatService;
    }

    /**
     * 获取用户服务
     *
     * @return {@link UserService} 用户服务
     * @link https://developer.kaiheila.cn/doc/http/user
     */
    public UserService getUserService() {
        return this.userService;
    }
}
