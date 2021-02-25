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

public class ReactionUserInfo extends UserInfo {

    private long reactionTime;

    public ReactionUserInfo() {
    }

    /**
     * <p>
     * 获得用户点击reaction的毫秒时间戳
     * </p>
     *
     * @return 用户点击reaction的毫秒时间戳
     */
    public long getReactionTime() {
        return reactionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReactionUserInfo that = (ReactionUserInfo) o;
        return reactionTime == that.reactionTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reactionTime);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ReactionUserInfo.class.getSimpleName() + "[", "]")
                .add("reactionTime=" + reactionTime)
                .toString();
    }
}
