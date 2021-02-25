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

public class ChannelRolesInfo implements Serializable {

    private List<ChannelRoleInfo> permissionOverwrites;
    private List<ChannelUserRoleInfo> permissionUsers;
    private int permissionSync;

    public ChannelRolesInfo() {
    }

    /**
     * <p>
     * 获得频道权限覆写的角色列表
     * </p>
     *
     * @return 频道权限覆写的角色列表
     */
    public List<ChannelRoleInfo> getPermissionOverwrites() {
        return permissionOverwrites;
    }

    /**
     * <p>
     * 获得频道权限覆写的用户列表
     * </p>
     *
     * @return 频道权限覆写的用户列表
     */
    public List<ChannelUserRoleInfo> getPermissionUsers() {
        return permissionUsers;
    }

    /**
     * <p>
     * 是否同步分组的权限
     * </p>
     *
     * @return 是否同步分组的权限
     */
    public int getPermissionSync() {
        return permissionSync;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChannelRolesInfo that = (ChannelRolesInfo) o;
        return permissionSync == that.permissionSync && Objects.equals(permissionOverwrites, that.permissionOverwrites) && Objects.equals(permissionUsers, that.permissionUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionOverwrites, permissionUsers, permissionSync);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ChannelRolesInfo.class.getSimpleName() + "[", "]")
                .add("permissionOverwrites=" + permissionOverwrites)
                .add("permissionUsers=" + permissionUsers)
                .add("permissionSync=" + permissionSync)
                .toString();
    }
}
