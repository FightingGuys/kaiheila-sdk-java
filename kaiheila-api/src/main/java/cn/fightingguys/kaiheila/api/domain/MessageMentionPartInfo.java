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

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class MessageMentionPartInfo implements Serializable {

    private String id;
    private String username;
    private String fullName;
    private String avatar;

    public MessageMentionPartInfo() {
    }

    /**
     * <p>
     * 获得用户id
     * </p>
     *
     * @return 用户id
     */
    public String getId() {
        return id;
    }

    /**
     * <p>
     * 获得用户名字
     * </p>
     *
     * @return 用户名字
     */
    public String getUsername() {
        return username;
    }

    /**
     * <p>
     * 获得用户的全名：user_name#identify_num
     * </p>
     *
     * @return 用户的全名
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * <p>
     * 获得用户头像
     * </p>
     *
     * @return 用户头像
     */
    public String getAvatar() {
        return avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageMentionPartInfo that = (MessageMentionPartInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(fullName, that.fullName) && Objects.equals(avatar, that.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, fullName, avatar);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MessageMentionPartInfo.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("username='" + username + "'")
                .add("fullName='" + fullName + "'")
                .add("avatar='" + avatar + "'")
                .toString();
    }
}
