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
import cn.fightingguys.kaiheila.api.domain.ChannelMessageAction;
import cn.fightingguys.kaiheila.api.domain.ChannelRoleAction;
import cn.fightingguys.kaiheila.api.domain.ChannelRolesInfo;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;

public interface ChannelService {

    /**
     * 发送消息到某个频道
     *
     * @param type         消息类型, 见[objectName], 不传默认为 1, 代表文本类型。2 图片消息，3 视频消息，4 文件消息，9 代表 kmarkdown 消息, 10 代表卡片消息。
     * @param channelId    目标频道 id
     * @param content      消息内容
     * @param quote        回复某条消息的 msgId
     * @param nonce        nonce, 服务端不做处理, 原样返回
     * @param tempTargetId 用户id,如果传了，代表该消息是临时消息，该消息不会存数据库，但是会在频道内只给该用户推送临时消息。用于在频道内针对用户的操作进行单独的回应通知等。
     * @return {@link ChannelMessageAction}
     * @throws KHLAPIServiceException
     * @see MessageService#sendMessage
     */
    @Deprecated
    @RestRequest("v3/channel/message")
    ChannelMessageAction message(@Query("type") int type,
                                 @Query("channel_id") String channelId,
                                 @Query("content") String content,
                                 @Query("quote") String quote,
                                 @Query("nonce") String nonce,
                                 @Query("temp_target_id") String tempTargetId) throws KHLAPIServiceException;

    /**
     * 频道角色权限详情
     *
     * @param channelId
     * @return {@link ChannelRolesInfo}
     * @throws KHLAPIServiceException
     */
    @RestRequest("v3/channel-role/index")
    ChannelRolesInfo listChannelRole(@Query("channel_id") String channelId) throws KHLAPIServiceException;

    /**
     * 创建频道角色权限
     *
     * @param channelId 频道id, 如果频道是分组的id,会同步给所有sync=1的子频道
     * @param type      value的类型，只能为"role_id","user_id",不传则默认为"role_id"
     * @param value     value的值
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/channel-role/create", method = RestRequestService.HttpMethod.POST)
    void createChannelRole(@Field("channel_id") String channelId,
                           @Field("type") String type,
                           @Field("value") String value) throws KHLAPIServiceException;

    /**
     * 更新频道角色权限
     *
     * @param channelId 频道id, 如果频道是分组的id,会同步给所有sync=1的子频道
     * @param type      value的类型，只能为"role_id","user_id",不传则默认为"role_id"
     * @param value     value的值
     * @param allow     默认为0,想要设置的允许的权限值
     * @param deny      默认为0,想要设置的拒绝的权限值
     * @return {@link ChannelRoleAction}
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/channel-role/update", method = RestRequestService.HttpMethod.POST)
    ChannelRoleAction updateChannelRole(@Field("channel_id") String channelId,
                                        @Field("type") String type,
                                        @Field("value") String value,
                                        @Field("allow") int allow,
                                        @Field("deny") int deny) throws KHLAPIServiceException;

    /**
     * 删除频道角色权限
     *
     * @param channelId 频道id, 如果频道是分组的id,会同步给所有sync=1的子频道
     * @param type      value的类型，只能为"role_id","user_id",不传则默认为"role_id"
     * @param value     value的值，默认为0
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/channel-role/delete", method = RestRequestService.HttpMethod.POST)
    void deleteChannelRole(@Field("channel_id") String channelId,
                           @Field("type") String type,
                           @Field("value") String value) throws KHLAPIServiceException;

}
