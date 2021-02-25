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

import cn.fightingguys.kaiheila.api.service.*;

/**
 * 开黑啦 API 服务
 *
 * @link https://developer.kaiheila.cn/doc/reference
 */
public interface KHLRestApiService {

    /**
     * API base url
     *
     * @link https://developer.kaiheila.cn/doc/reference
     */
    String API_ENDPOINT_BASE_URL = "https://www.kaiheila.cn/api/";

    /**
     * 获取媒体服务
     *
     * @return {@link AssetService} 媒体服务
     * @link https://developer.kaiheila.cn/doc/http/asset
     */
    AssetService getAssetService();

    /**
     * 获取频道服务
     *
     * @return {@link ChannelService} 频道服务
     * @link https://developer.kaiheila.cn/doc/http/channel
     */
    ChannelService getChannelService();

    /**
     * 获取 WebSocket 接口 Gateway 服务
     *
     * @return {@link GatewayService} Gateway服务
     * @link https://developer.kaiheila.cn/doc/http/gateway
     */
    GatewayService getGatewayService();

    /**
     * 获取服务器表情服务
     *
     * @return {@link GuildEmoji} 服务器表情服务
     * @link https://developer.kaiheila.cn/doc/http/guild-emoji
     */
    GuildEmoji getGuildEmoji();

    /**
     * 获取服务器服务
     *
     * @return {@link GuildService} 服务器服务
     * @link https://developer.kaiheila.cn/doc/http/guild
     */
    GuildService getGuildService();

    /**
     * 获取亲密度服务
     *
     * @return {@link IntimacyService} 亲密度服务
     * @link https://developer.kaiheila.cn/doc/http/intimacy
     */
    IntimacyService getIntimacyService();

    /**
     * 获取频道消息服务
     *
     * @return {@link MessageService} 频道消息服务
     * @link https://developer.kaiheila.cn/doc/http/message
     */
    MessageService getMessageService();

    /**
     * 获取角色服务
     *
     * @return {@link GuildRoleService} 角色服务
     * @link https://developer.kaiheila.cn/doc/http/guild-role
     */
    GuildRoleService getGuildRoleService();

    /**
     * 获取私聊服务
     *
     * @return {@link UserChatService} 私聊服务
     * @link https://developer.kaiheila.cn/doc/http/user-chat
     */
    UserChatService getUserChat();

    /**
     * 获取用户服务
     *
     * @return {@link UserService} 用户服务
     * @link https://developer.kaiheila.cn/doc/http/user
     */
    UserService getUserService();
}
