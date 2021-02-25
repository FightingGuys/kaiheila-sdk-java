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

public class MessageReactionInfo implements Serializable {

    private ReactionEmojiInfo emoji;

    private int count;

    private boolean me;

    public MessageReactionInfo() {
    }

    /**
     * <p>
     * 获得表情信息
     * </p>
     *
     * @return {@link ReactionEmojiInfo} 表情信息
     */
    public ReactionEmojiInfo getEmoji() {
        return emoji;
    }

    /**
     * <p>
     * 有多少用户添加了这个表情
     * </p>
     *
     * @return 添加表情的用户数量
     */
    public int getCount() {
        return count;
    }

    /**
     * <p>
     * 我是否添加了这个表情
     * </p>
     *
     * @return 我是否添加了这个表情
     */
    public boolean isMe() {
        return me;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageReactionInfo that = (MessageReactionInfo) o;
        return count == that.count && me == that.me && Objects.equals(emoji, that.emoji);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emoji, count, me);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MessageReactionInfo.class.getSimpleName() + "[", "]")
                .add("emoji=" + emoji)
                .add("count=" + count)
                .add("me=" + me)
                .toString();
    }
}
