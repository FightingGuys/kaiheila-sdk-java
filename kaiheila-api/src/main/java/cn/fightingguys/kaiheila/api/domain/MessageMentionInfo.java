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

public class MessageMentionInfo implements Serializable {

    private List<MessageMentionPartInfo> mentionPart;
    private List<GuildRoleInfo> mentionRolePart;

    public MessageMentionInfo() {
    }

    /**
     * <p>
     * 获得 @特定用户 详情
     * </p>
     *
     * @return {@link MessageMentionPartInfo} @特定用户 详情
     */
    public List<MessageMentionPartInfo> getMentionPart() {
        return mentionPart;
    }

    /**
     * <p>
     * 获得 @特定角色 详情
     * </p>
     *
     * @return {@link GuildRoleInfo} @特定角色 详情
     */
    public List<GuildRoleInfo> getMentionRolePart() {
        return mentionRolePart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageMentionInfo that = (MessageMentionInfo) o;
        return Objects.equals(mentionPart, that.mentionPart) && Objects.equals(mentionRolePart, that.mentionRolePart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentionPart, mentionRolePart);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MessageMentionInfo.class.getSimpleName() + "[", "]")
                .add("mentionPart=" + mentionPart)
                .add("mentionRolePart=" + mentionRolePart)
                .toString();
    }
}
