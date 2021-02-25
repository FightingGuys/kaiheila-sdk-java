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
import cn.fightingguys.kaiheila.api.core.request.annotation.Field;
import cn.fightingguys.kaiheila.api.core.request.annotation.FormUrlEncoded;
import cn.fightingguys.kaiheila.api.core.request.annotation.Query;
import cn.fightingguys.kaiheila.api.core.request.annotation.RestRequest;
import cn.fightingguys.kaiheila.api.domain.GuildEmojiInfo;
import cn.fightingguys.kaiheila.api.domain.GuildRoleAction;
import cn.fightingguys.kaiheila.api.domain.GuildRoleInfo;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;

import java.util.List;

public interface GuildRoleService {

    /**
     * 获取服务器角色列表
     *
     * @param guildId 服务器的id
     * @return {@link GuildEmojiInfo}
     * @throws KHLAPIServiceException
     */
    @RestRequest("v3/guild-role/index")
    List<GuildEmojiInfo> listRolesByGuild(@Query("guild_id") String guildId) throws KHLAPIServiceException;

    /**
     * 创建服务器角色
     *
     * @param name    如果不写，则为"新角色"
     * @param guildId 服务器id
     * @return {@link GuildRoleInfo}
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/guild-role/create", method = RestRequestService.HttpMethod.POST)
    GuildRoleInfo createGuildRole(@Field("name") String name,
                                  @Field("guild_id") String guildId) throws KHLAPIServiceException;

    /**
     * 更新服务器角色
     *
     * @param guildId     服务器id
     * @param roleId      角色id
     * @param hoist       只能为0或者1，是否把该角色的用户在用户列表排到前面
     * @param mentionable 只能为0或者1，该角色是否可以被提及
     * @param permissions 权限
     * @param color       色值
     * @param name        角色名
     * @return {@link GuildRoleInfo}
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/guild-role/update", method = RestRequestService.HttpMethod.POST)
    GuildRoleInfo updateGuildRole(@Field("guild_id") String guildId,
                                  @Field("role_id") long roleId,
                                  @Field("hoist") long hoist,
                                  @Field("mentionable") long mentionable,
                                  @Field("permissions") long permissions,
                                  @Field("color") long color,
                                  @Field("name") String name) throws KHLAPIServiceException;

    /**
     * 删除服务器角色
     *
     * @param guildId 服务器id
     * @param roleId  角色id
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/guild-role/delete", method = RestRequestService.HttpMethod.POST)
    void deleteGuildRole(@Field("guild_id") String guildId,
                         @Field("role_id") long roleId) throws KHLAPIServiceException;

    /**
     * 赋予用户角色
     *
     * @param guildId 服务器id
     * @param userId  用户id
     * @param roleId  角色id
     * @return {@link GuildRoleAction}
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/guild-role/grant", method = RestRequestService.HttpMethod.POST)
    GuildRoleAction grantUserRole(@Field("guild_id") String guildId,
                                  @Field("user_id") String userId,
                                  @Field("role_id") long roleId) throws KHLAPIServiceException;

    /**
     * 删除用户角色
     *
     * @param guildId 服务器id
     * @param roleId  角色id
     * @param userId  用户id
     * @return {@link GuildRoleAction}
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/guild-role/revoke", method = RestRequestService.HttpMethod.POST)
    GuildRoleAction revokeUserRole(@Field("guild_id") String guildId,
                                   @Field("role_id") long roleId,
                                   @Field("user_id") String userId) throws KHLAPIServiceException;

}
