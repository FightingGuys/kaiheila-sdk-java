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

public class ChannelUserRoleInfo implements Serializable {

    private GuildUserInfo user;
    private long allow;
    private long deny;

    public ChannelUserRoleInfo() {
    }

    /**
     * <p>
     * 获得用户信息
     * </p>
     *
     * @return {@link GuildUserInfo} 用户信息
     */
    public GuildUserInfo getUser() {
        return user;
    }

    /**
     * <p>
     * 获得最终修改成功后，允许的权限的结果集
     * </p>
     *
     * @return 最终修改成功后，允许的权限的结果集
     */
    public long getAllow() {
        return allow;
    }

    /**
     * <p>
     * 获得最终修改成功后，拒绝的权限的结果集
     * </p>
     *
     * @return 最终修改成功后，拒绝的权限的结果集
     */
    public long getDeny() {
        return deny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChannelUserRoleInfo that = (ChannelUserRoleInfo) o;
        return allow == that.allow && deny == that.deny && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, allow, deny);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ChannelUserRoleInfo.class.getSimpleName() + "[", "]")
                .add("user=" + user)
                .add("allow=" + allow)
                .add("deny=" + deny)
                .toString();
    }
}
