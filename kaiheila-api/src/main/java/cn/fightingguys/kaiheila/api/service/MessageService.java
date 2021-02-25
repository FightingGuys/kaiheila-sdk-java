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
import cn.fightingguys.kaiheila.api.domain.ChannelMessageAction;
import cn.fightingguys.kaiheila.api.domain.MessageInfo;
import cn.fightingguys.kaiheila.api.domain.ReactionUserInfo;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;

import java.util.List;

public interface MessageService {

    /**
     * 获取频道聊天消息列表
     *
     * @param channelId 频道 id
     * @param msgId     参考消息 id，不传则默认为最新的消息 id
     * @param pin       只能为0或者1，是否查询置顶消息
     * @param flag      查询模式，有三种模式可以选择。不传则默认查询最新的消息
     * @return {@link MessageInfo}
     * @throws KHLAPIServiceException
     */
    @Pageable
    @RestRequest("v3/message/list")
    List<MessageInfo> listChannelMessage(@Query("channel_id") String channelId,
                                         @Query("msg_id") String msgId,
                                         @Query("pin") long pin,
                                         @Query("flag") String flag) throws KHLAPIServiceException;

    /**
     * 发送频道聊天消息
     *
     * @param type         消息类型, 见[objectName], 不传默认为 1, 代表文本类型。2 图片消息，3 视频消息，4 文件消息，9 代表 kmarkdown 消息, 10 代表卡片消息。
     * @param channelId    目标频道 id
     * @param content      消息内容
     * @param quote        回复某条消息的 msgId
     * @param nonce        nonce, 服务端不做处理, 原样返回
     * @param tempTargetId 用户id,如果传了，代表该消息是临时消息，该消息不会存数据库，但是会在频道内只给该用户推送临时消息。用于在频道内针对用户的操作进行单独的回应通知等。
     * @return {@link ChannelMessageAction}
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/message/create", method = RestRequestService.HttpMethod.POST)
    ChannelMessageAction sendMessage(@Field("type") int type,
                                     @Field("channel_id") String channelId,
                                     @Field("content") String content,
                                     @Field("quote") String quote,
                                     @Field("nonce") String nonce,
                                     @Field("temp_target_id") String tempTargetId) throws KHLAPIServiceException;

    /**
     * 更新频道聊天消息
     *
     * @param msgId   消息 id
     * @param content 消息内容
     * @param quote   回复某条消息的 msgId。如果为空，则代表删除回复，不传则无影响。
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/message/update", method = RestRequestService.HttpMethod.POST)
    void updateMessage(@Field("msg_id") String msgId,
                       @Field("content") String content,
                       @Field("quote") String quote) throws KHLAPIServiceException;

    /**
     * 删除频道聊天消息
     *
     * @param msgId 消息 id
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/message/delete", method = RestRequestService.HttpMethod.POST)
    void deleteMessage(@Field("msg_id") String msgId) throws KHLAPIServiceException;

    /**
     * 获取频道消息某回应的用户列表
     *
     * @param msgId 频道消息的id
     * @param emoji emoji的id, 可以为GuilEmoji或者Emoji
     * @return {@link ReactionUserInfo}
     * @throws KHLAPIServiceException
     */
    @RestRequest("v3/message/reaction-list")
    List<ReactionUserInfo> listReaction(@Query("msg_id") String msgId,
                                        @Query("emoji") String emoji) throws KHLAPIServiceException;

    /**
     * 给某个消息添加回应
     *
     * @param msgId 频道消息的id
     * @param emoji emoji的id, 可以为GuilEmoji或者Emoji
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/message/add-reaction", method = RestRequestService.HttpMethod.POST)
    void addReaction(@Field("msg_id") String msgId,
                     @Field("emoji") String emoji) throws KHLAPIServiceException;

    /**
     * 删除消息的某个回应
     *
     * @param msgId  频道消息的id
     * @param emoji  emoji的id, 可以为GuilEmoji或者Emoji
     * @param userId 用户的id, 如果不填则为自己的id。删除别人的reaction需要有管理频道消息的权限
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/message/delete-reaction", method = RestRequestService.HttpMethod.POST)
    void deleteReaction(@Field("msg_id") String msgId,
                        @Field("emoji") String emoji,
                        @Field("user_id") String userId) throws KHLAPIServiceException;
}
