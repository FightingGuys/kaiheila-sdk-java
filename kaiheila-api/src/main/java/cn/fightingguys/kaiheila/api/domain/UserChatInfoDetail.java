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

import java.util.Objects;
import java.util.StringJoiner;

public class UserChatInfoDetail extends UserChatInfo {

    private boolean isFriend;
    private boolean isBlocked;
    private boolean isTargetBlocked;

    public UserChatInfoDetail() {
    }

    /**
     * <p>
     * 是否是好友
     * </p>
     *
     * @return 是否是好友
     */
    public boolean isFriend() {
        return isFriend;
    }

    /**
     * <p>
     * 是否已屏蔽对方
     * </p>
     *
     * @return 是否已屏蔽对方
     */
    public boolean isBlocked() {
        return isBlocked;
    }

    /**
     * <p>
     * 是否已被对方屏蔽
     * </p>
     *
     * @return 是否已被对方屏蔽
     */
    public boolean isTargetBlocked() {
        return isTargetBlocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserChatInfoDetail that = (UserChatInfoDetail) o;
        return isFriend == that.isFriend && isBlocked == that.isBlocked && isTargetBlocked == that.isTargetBlocked;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFriend, isBlocked, isTargetBlocked);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserChatInfoDetail.class.getSimpleName() + "[", "]")
                .add("isFriend=" + isFriend)
                .add("isBlocked=" + isBlocked)
                .add("isTargetBlocked=" + isTargetBlocked)
                .toString();
    }
}
