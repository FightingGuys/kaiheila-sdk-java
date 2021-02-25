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

public class GuildRoleInfo implements Serializable {

    private int roleId;
    private String name;
    private int color;
    private int position;
    private int hoist;
    private int mentionable;
    private int permissions;

    public GuildRoleInfo() {
    }

    /**
     * <p>
     * 获得角色的id
     * </p>
     *
     * @return 角色的id
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * <p>
     * 获得角色的名称
     * </p>
     *
     * @return 角色的名称
     */
    public String getName() {
        return name;
    }

    /**
     * <p>
     * 获得角色的色值0x000000 - 0xFFFFFF
     * </p>
     *
     * @return 角色的色值
     */
    public int getColor() {
        return color;
    }

    /**
     * <p>
     * 获得角色在列表中的位置，值越小越靠前
     * </p>
     *
     * @return 角色在列表中的位置
     */
    public int getPosition() {
        return position;
    }

    /**
     * <p>
     * 是否把该角色的用户在用户列表排到前面，只能为0或者1。
     * </p>
     *
     * @return 0:正常排序 1:排在前面
     */
    public int getHoist() {
        return hoist;
    }

    /**
     * <p>
     * 该角色是否可以被提及,只能为0或者1。
     * </p>
     *
     * @return 0:不可以被提及 1:可以被提及
     */
    public int getMentionable() {
        return mentionable;
    }

    /**
     * <p>
     * 获得角色的权限
     *
     * @return 角色的权限
     * @link https://developer.kaiheila.cn/doc/http/guild-role
     * </p>
     */
    public int getPermissions() {
        return permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuildRoleInfo that = (GuildRoleInfo) o;
        return roleId == that.roleId && color == that.color && position == that.position && hoist == that.hoist && mentionable == that.mentionable && permissions == that.permissions && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, name, color, position, hoist, mentionable, permissions);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GuildRoleInfo.class.getSimpleName() + "[", "]")
                .add("roleId=" + roleId)
                .add("name='" + name + "'")
                .add("color=" + color)
                .add("position=" + position)
                .add("hoist=" + hoist)
                .add("mentionable=" + mentionable)
                .add("permissions=" + permissions)
                .toString();
    }
}
