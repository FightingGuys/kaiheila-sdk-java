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

package cn.fightingguys.kaiheila.api.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * 用户信息
 * User Info
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonSubTypes({@JsonSubTypes.Type(value = GuildUserInfo.class), @JsonSubTypes.Type(value = ReactionUserInfo.class)})
public class UserInfo implements Serializable {

    private String id;
    private String username;
    private String identifyNum;
    private boolean online;
    private int status;
    private String avatar;
    private boolean bot;
    private UserTagInfo tagInfo;
    private boolean mobileVerified;
    private String clientId;
    private String mobilePrefix;
    private String mobile;
    private int invitedCount;

    public UserInfo() {
    }

    /**
     * <p>
     * 获得用户的id
     * </p>
     *
     * @return 用户的id
     */
    public String getId() {
        return id;
    }

    /**
     * <p>
     * 获得用户的名称，用户名正常为：user_name#identify_num
     * </p>
     *
     * @return 用户的名称
     */
    public String getUsername() {
        return username;
    }

    /**
     * <p>
     * 获得用户的认证数字，用户名正常为：user_name#identify_num
     * </p>
     *
     * @return 用户名的认证数字
     */
    public String getIdentifyNum() {
        return identifyNum;
    }

    /**
     * <p>
     * 检查当前是否在线
     * </p>
     *
     * @return true:在线 false:离线
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * <p>
     * 返回用户的状态
     * </p>
     *
     * @return 用户的状态, 0代表正常，10代表被封禁
     */
    public int getStatus() {
        return status;
    }

    /**
     * <p>
     * 返回用户的头像的url地址
     * </p>
     *
     * @return 用户的头像的url地址
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * <p>
     * 检查用户是否为机器人
     * </p>
     *
     * @return true:机器人 false:活人
     */
    public boolean isBot() {
        return bot;
    }

    /**
     * <p>
     * 用户标签信息
     * </p>
     * 例如：开黑啦、机器人 等等小标签
     *
     * @return 用户标签
     */
    public UserTagInfo getTagInfo() {
        return tagInfo;
    }

    /**
     * <p>
     * 检查是否手机号已验证
     * </p>
     *
     * @return true:手机号已验证 false:手机号未验证
     */
    public boolean isMobileVerified() {
        return mobileVerified;
    }

    /**
     * <p>
     * 检查是否为官方账号
     * </p>
     *
     * @return true:是官方人员 false:非官方人员
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * <p>
     * 返回手机区号，如中国为86
     * </p>
     *
     * @return 手机区号
     */
    public String getMobilePrefix() {
        return mobilePrefix;
    }

    /**
     * <p>
     * 返回用户手机号，带掩码
     * </p>
     *
     * @return 用户手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * <p>
     * 返回当前邀请注册的人数
     * </p>
     *
     * @return 当前邀请注册的人数
     */
    public int getInvitedCount() {
        return invitedCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return online == userInfo.online && status == userInfo.status && bot == userInfo.bot && mobileVerified == userInfo.mobileVerified && invitedCount == userInfo.invitedCount && Objects.equals(id, userInfo.id) && Objects.equals(username, userInfo.username) && Objects.equals(identifyNum, userInfo.identifyNum) && Objects.equals(avatar, userInfo.avatar) && Objects.equals(tagInfo, userInfo.tagInfo) && Objects.equals(clientId, userInfo.clientId) && Objects.equals(mobilePrefix, userInfo.mobilePrefix) && Objects.equals(mobile, userInfo.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, identifyNum, online, status, avatar, bot, tagInfo, mobileVerified, clientId, mobilePrefix, mobile, invitedCount);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserInfo.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("username='" + username + "'")
                .add("identifyNum='" + identifyNum + "'")
                .add("online=" + online)
                .add("status=" + status)
                .add("avatar='" + avatar + "'")
                .add("bot=" + bot)
                .add("tagInfo=" + tagInfo)
                .add("mobileVerified=" + mobileVerified)
                .add("clientId='" + clientId + "'")
                .add("mobilePrefix='" + mobilePrefix + "'")
                .add("mobile='" + mobile + "'")
                .add("invitedCount=" + invitedCount)
                .toString();
    }
}
