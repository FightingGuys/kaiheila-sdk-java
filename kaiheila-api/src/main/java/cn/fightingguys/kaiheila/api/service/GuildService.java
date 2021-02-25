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

package cn.fightingguys.kaiheila.api.service;

import cn.fightingguys.kaiheila.api.core.request.RestRequestService;
import cn.fightingguys.kaiheila.api.core.request.annotation.*;
import cn.fightingguys.kaiheila.api.domain.GuildInfo;
import cn.fightingguys.kaiheila.api.domain.GuildMuteInfo;
import cn.fightingguys.kaiheila.api.domain.GuildUsersInfo;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;

import java.util.List;

public interface GuildService {

    /**
     * 当前机器人已经加入的服务器列表
     */
    @Pageable
    @RestRequest("v3/guild/list")
    List<GuildInfo> listJoinedGuild() throws KHLAPIServiceException;

    /**
     * 获取当前服务器用户列表
     *
     * @param guildId        服务器的 ID
     * @param channelId      服务器中频道的 ID
     * @param search         搜索关键字，在用户名或昵称中搜索
     * @param roleId         角色 ID，获取特定角色的用户列表
     * @param mobileVerified 只能为`0`或`1`，`0`是未认证，`1`是已认证
     * @param activeTime     根据活跃时间排序，`0`是顺序排列，`1`是倒序排列
     * @return {@link GuildUsersInfo}
     */
    @Pageable
    @RestRequest("v3/guild/user-list")
    GuildUsersInfo listUserList(
            @Query("guild_id") String guildId,
            @Query("channel_id") String channelId,
            @Query("search") String search,
            @Query("role_id") int roleId,
            @Query("mobile_verified") int mobileVerified,
            @Query("active_time") int activeTime,
            @Query("joined_at") int joinedAt) throws KHLAPIServiceException;

    /**
     * 修改某个服务器的用户名称
     *
     * @param guildId  服务器的 ID
     * @param nickname 昵称，2 - 64 长度，不传则清空昵称
     * @param userId   要修改昵称的目标用户 ID，不传则修改当前登陆用户的昵称
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/guild/nickname", method = RestRequestService.HttpMethod.POST)
    void changeUserNickname(
            @Field("guild_id") String guildId,
            @Field("nickname") String nickname,
            @Field("user_id") String userId) throws KHLAPIServiceException;

    /**
     * 机器人用户离开服务器
     *
     * @param guildId 服务器id
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/guild/nickname", method = RestRequestService.HttpMethod.POST)
    void leaveGuild(@Field("guild_id") String guildId) throws KHLAPIServiceException;

    /**
     * 从某个服务器提出用户
     *
     * @param guildId  服务器ID
     * @param targetId 目标用户ID
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/guild/kickout", method = RestRequestService.HttpMethod.POST)
    void kickUser(
            @Field("guild_id") String guildId,
            @Field("target_id") String targetId) throws KHLAPIServiceException;

    /**
     * 获取某个服务器的禁言列表
     *
     * @param guildId 服务器的 ID
     */
    @RestRequest("v3/guild-mute/list")
    List<GuildMuteInfo> listGuildMute(@Query("guild_id") String guildId) throws KHLAPIServiceException;

    /**
     * 禁言某个服务器的用户
     *
     * @param guildId 服务器的 ID
     * @param userId  用户 ID
     * @param type    1代表麦克风闭麦，2代表耳机静音
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/guild-mute/create", method = RestRequestService.HttpMethod.POST)
    void muteUser(
            @Field("guild_id") String guildId,
            @Field("user_id") String userId,
            @Field("type") String type) throws KHLAPIServiceException;

    /**
     * 解除禁言某个服务器的用户
     *
     * @param guildId 服务器的 ID
     * @param userId  用户 ID
     * @param type    1代表麦克风闭麦，2代表耳机静音
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/guild-mute/delete", method = RestRequestService.HttpMethod.POST)
    void unmuteUser(
            @Field("guild_id") String guildId,
            @Field("user_id") String userId,
            @Field("type") String type) throws KHLAPIServiceException;

}
