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
import cn.fightingguys.kaiheila.api.domain.*;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;

import java.util.List;

/**
 * 用户私聊服务
 * Discord 的 DM(Direct Message)
 * 首先创建私聊会话，然后才可以进行私聊
 *
 * @link https://developer.kaiheila.cn/doc/http/user-chat
 */
public interface UserChatService {

    /**
     * 获取私信聊天会话列表
     *
     * @return {@link UserChatInfo} 私信聊天会话列表
     */
    @RestRequest("v3/user-chat/index")
    List<UserChatInfo> listUserChat() throws KHLAPIServiceException;

    /**
     * 获取私信会话详情
     *
     * @param chatCode 私聊会话 Code
     * @return {@link UserChatInfoDetail} 私信会话详情
     */
    @RestRequest("v3/user-chat/view")
    UserChatInfoDetail viewUserChat(@Query("chat_code") String chatCode) throws KHLAPIServiceException;

    /**
     * 创建私信会话
     *
     * @param targetId 目标用户 id
     * @return {@link UserChatInfoDetail} 私信会话详情
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/user-chat/create", method = RestRequestService.HttpMethod.POST)
    UserChatInfoDetail createUserChat(@Field("target_id") String targetId) throws KHLAPIServiceException;

    /* 官方暂无接口 */
//    /**
//     * 更新私信聊天会话
//     */
//    void updateUserChat() throws KHLAPIServiceException;

    /**
     * 删除私信聊天会话
     *
     * @param chatCode 私信会话 Code
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/user-chat/delete", method = RestRequestService.HttpMethod.POST)
    void deleteUserChat(@Field("chat_code") String chatCode) throws KHLAPIServiceException;

    /**
     * 获取私信聊天消息列表
     *
     * <pre>
     * 查询模式:
     * before   查询参考消息之前的消息，不包括参考消息
     * around   查询以参考消息为中心，前后一定数量的消息
     * after    查询参考消息之后的消息，不包括参考消息
     * </pre>
     *
     * @param chatCode 私信会话 Code
     * @param msgId    参考消息 id，不传则默认为最新的消息
     * @param flag     查询模式，有三种模式可以选择。不传则默认查询最新的消息
     */
    @RestRequest("v3/user-chat/msg-list")
    List<MessageInfo> listMessage(@Query("chat_code") String chatCode,
                                  @Query("msg_id") String msgId,
                                  @Query("flag") String flag) throws KHLAPIServiceException;

    /**
     * 发送私信聊天消息
     *
     * @param type     消息类型
     * @param chatCode 目标会话 id
     * @param content  消息内容
     * @param quote    回复某条消息的 msgId
     * @param nonce    服务端不做处理, 原样返回
     * @return {@link ChannelMessageAction} 消息操作信息
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/user-chat/create-msg", method = RestRequestService.HttpMethod.POST)
    ChannelMessageAction sendMessage(@Field("type") int type,
                                     @Field("chat_code") String chatCode,
                                     @Field("content") String content,
                                     @Field("quote") String quote,
                                     @Field("nonce") String nonce) throws KHLAPIServiceException;

    /**
     * 更新私信聊天消息
     *
     * @param msgId   消息 id
     * @param content 消息内容
     * @param quote   回复某条消息的 msgId。如果为空，则代表删除回复，不传则无影响。
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/user-chat/update-msg", method = RestRequestService.HttpMethod.POST)
    void updateMessage(@Field("msg_id") int msgId,
                       @Field("content") String content,
                       @Field("quote") String quote) throws KHLAPIServiceException;

    /**
     * 删除私信聊天消息
     *
     * @param msgId 消息 id
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/user-chat/delete-msg", method = RestRequestService.HttpMethod.POST)
    void deleteMessage(@Field("msg_id") String msgId) throws KHLAPIServiceException;

    /**
     * 获取频道消息某回应的用户列表
     *
     * @param msgId 频道消息的id
     * @param emoji emoji的id, 可以为GuilEmoji或者Emoji, 注意：在get中，应该进行urlencode
     * @return {@link ReactionUserInfo}
     * @throws KHLAPIServiceException
     */
    @RestRequest("v3/user-chat/reaction-list")
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
    @RestRequest(value = "v3/user-chat/add-reaction", method = RestRequestService.HttpMethod.POST)
    void addReaction(@Field("msg_id") String msgId,
                     @Field("emoji") String emoji) throws KHLAPIServiceException;

    /**
     * 删除消息的某个回应
     *
     * @param msgId 频道消息的id
     * @param emoji emoji的id, 可以为GuilEmoji或者Emoji
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/user-chat/delete-reaction", method = RestRequestService.HttpMethod.POST)
    void deleteReaction(@Field("msg_id") String msgId,
                        @Field("emoji") String emoji) throws KHLAPIServiceException;

}
