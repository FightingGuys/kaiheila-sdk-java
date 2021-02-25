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

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonSubTypes({@JsonSubTypes.Type(value = UserChatInfoDetail.class)})
public class UserChatInfo implements Serializable {

    private String code;
    private long lastReadTime;
    private long latestMsgTime;
    private long unreadCount;
    private UserInfo targetInfo;

    public UserChatInfo() {
    }

    /**
     * <p>
     * 获得私信会话 Code
     * </p>
     *
     * @return 私信会话 Code
     */
    public String getCode() {
        return code;
    }

    /**
     * <p>
     * 获得上次阅读消息的时间
     * </p>
     *
     * @return 上次阅读消息的时间
     */
    public long getLastReadTime() {
        return lastReadTime;
    }

    /**
     * <p>
     * 获得最新消息时间
     * </p>
     *
     * @return 最新消息时间
     */
    public long getLatestMsgTime() {
        return latestMsgTime;
    }

    /**
     * <p>
     * 获得未读消息数
     * </p>
     *
     * @return 未读消息数
     */
    public long getUnreadCount() {
        return unreadCount;
    }

    /**
     * <p>
     * 获得目标用户信息
     * </p>
     *
     * @return {@link UserInfo} 目标用户信息
     */
    public UserInfo getTargetInfo() {
        return targetInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserChatInfo that = (UserChatInfo) o;
        return lastReadTime == that.lastReadTime && latestMsgTime == that.latestMsgTime && unreadCount == that.unreadCount && Objects.equals(code, that.code) && Objects.equals(targetInfo, that.targetInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, lastReadTime, latestMsgTime, unreadCount, targetInfo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserChatInfo.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("lastReadTime=" + lastReadTime)
                .add("latestMsgTime=" + latestMsgTime)
                .add("unreadCount=" + unreadCount)
                .add("targetInfo=" + targetInfo)
                .toString();
    }
}
