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

/**
 * 服务器表情类
 */
public class GuildEmojiInfo implements Serializable {

    private String name;

    private String id;

    private UserInfo userInfo;

    public GuildEmojiInfo() {
    }

    /**
     * <p>
     * 获得服务器表情名
     * </p>
     *
     * @return 服务器表情名
     */
    public String getName() {
        return name;
    }

    /**
     * <p>
     * 获得服务器表情id
     * </p>
     *
     * @return 服务器表情id
     */
    public String getId() {
        return id;
    }

    /**
     * <p>
     * 获得用户信息
     * </p>
     *
     * @return {@link UserInfo} 用户信息
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuildEmojiInfo that = (GuildEmojiInfo) o;
        return Objects.equals(name, that.name) && Objects.equals(id, that.id) && Objects.equals(userInfo, that.userInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, userInfo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GuildEmojiInfo.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("id='" + id + "'")
                .add("userInfo=" + userInfo)
                .toString();
    }
}
