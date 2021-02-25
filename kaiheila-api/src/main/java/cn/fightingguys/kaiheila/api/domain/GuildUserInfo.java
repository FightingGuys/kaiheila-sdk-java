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

public class GuildUserInfo extends UserInfo implements Serializable {

    private long joinedAt;
    private long activeTime;
    private List<Integer> roles;

    public GuildUserInfo() {
    }

    /**
     * <p>
     * 获得用户加入时间戳
     * </p>
     *
     * @return 用户加入时间戳
     */
    public long getJoinedAt() {
        return joinedAt;
    }

    /**
     * <p>
     * 获得用户活跃时间戳
     * </p>
     *
     * @return 用户活跃时间戳
     */
    public long getActiveTime() {
        return activeTime;
    }

    /**
     * <p>
     * 获得用户角色列表
     * </p>
     *
     * @return 用户角色列表
     */
    public List<Integer> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuildUserInfo that = (GuildUserInfo) o;
        return joinedAt == that.joinedAt && activeTime == that.activeTime && Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinedAt, activeTime, roles);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GuildUserInfo.class.getSimpleName() + "[", "]")
                .add("joinedAt=" + joinedAt)
                .add("activeTime=" + activeTime)
                .add("roles=" + roles)
                .toString();
    }
}
