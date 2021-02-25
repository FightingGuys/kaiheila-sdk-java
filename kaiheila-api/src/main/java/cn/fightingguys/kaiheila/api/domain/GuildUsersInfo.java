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
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class GuildUsersInfo implements Serializable {

    private List<GuildUserInfo> items;
    private int userCount;
    private int onlineCount;
    private int offlineCount;

    public GuildUsersInfo() {
    }

    /**
     * <p>
     * 获得用户列表
     * </p>
     *
     * @return 用户列表
     */
    public List<GuildUserInfo> getItems() {
        return items;
    }

    /**
     * <p>
     * 获得用户数量
     * </p>
     *
     * @return 用户数量
     */
    public int getUserCount() {
        return userCount;
    }

    /**
     * <p>
     * 获得在线用户数量
     * </p>
     *
     * @return 在线用户数量
     */
    public int getOnlineCount() {
        return onlineCount;
    }

    /**
     * <p>
     * 获得离线用户数量
     * </p>
     *
     * @return 离线用户数量
     */
    public int getOfflineCount() {
        return offlineCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuildUsersInfo that = (GuildUsersInfo) o;
        return userCount == that.userCount && onlineCount == that.onlineCount && offlineCount == that.offlineCount && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, userCount, onlineCount, offlineCount);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GuildUsersInfo.class.getSimpleName() + "[", "]")
                .add("items=" + items)
                .add("userCount=" + userCount)
                .add("onlineCount=" + onlineCount)
                .add("offlineCount=" + offlineCount)
                .toString();
    }
}
