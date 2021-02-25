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

public class MessageInfo implements Serializable {

    private String id;
    private int type;
    private String content;
    private List<String> mention;
    private boolean mentionAll;
    private List<String> mentionRoles;
    private boolean mentionHere;
    private List<MessageEmbedInfo> embeds;
    //    private List<> attachments;
    private long createAt;
    private long updatedAt;
    private List<MessageReactionInfo> reactions;

    private UserInfo author;

    private String imageName;
    private boolean readStatus;
    private MessageInfo quote;
    private MessageMentionInfo mentionInfo;

    public MessageInfo() {
    }

    /**
     * <p>
     * 获得消息 id
     * </p>
     *
     * @return 消息 id
     */
    public String getId() {
        return id;
    }

    /**
     * <p>
     * 获得消息类型
     * </p>
     *
     * @return 消息类型
     */
    public int getType() {
        return type;
    }

    /**
     * <p>
     * 获得消息内容
     * </p>
     *
     * @return 消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * <p>
     * 获得 @特定用户 的用户ID数组，与 mention_info 中的数据对应
     * </p>
     *
     * @return 用户ID数组
     */
    public List<String> getMention() {
        return mention;
    }

    /**
     * <p>
     * 是否含有 @全体人员
     * </p>
     *
     * @return 是否含有 @全体人员
     */
    public boolean isMentionAll() {
        return mentionAll;
    }

    /**
     * <p>
     * 获得 @特定角色 的角色ID数组，与 mention_info 中的数据对应
     * </p>
     *
     * @return 角色ID数组
     */
    public List<String> getMentionRoles() {
        return mentionRoles;
    }

    /**
     * <p>
     * 是否含有 @在线人员
     * </p>
     *
     * @return 是否含有 @在线人员
     */
    public boolean isMentionHere() {
        return mentionHere;
    }

    /**
     * <p>
     * 附加的多媒体数据
     * </p>
     *
     * @return 附加的多媒体
     */
    public List<MessageEmbedInfo> getEmbeds() {
        return embeds;
    }

    //    /**
//     * <p>
//     * 获得附加的多媒体数据
//     * </p>
//     *
//     * @return 附加的多媒体数据
//     */
//    public boolean isAttachments() {
//        return attachments;
//    }

    /**
     * <p>
     * 获得消息创建时间
     * </p>
     *
     * @return 消息创建时间
     */
    public long getCreateAt() {
        return createAt;
    }

    /**
     * <p>
     * 获得消息最后更改（包括添加删除回应，编辑文本）时间
     * </p>
     *
     * @return 消息最后更改时间
     */
    public long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * <p>
     * 获得回应数据
     * </p>
     *
     * @return {@link MessageReactionInfo} 回应数据
     */
    public List<MessageReactionInfo> getReactions() {
        return reactions;
    }

    /**
     * <p>
     * 获得作者的用户信息
     * </p>
     *
     * @return {@link UserInfo} 作者的用户信息
     */
    public UserInfo getAuthor() {
        return author;
    }

    /**
     * <p>
     * 获得图片名字
     * </p>
     *
     * @return 图片名字
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * <p>
     * 是否 已读消息
     * </p>
     *
     * @return 是否 已读消息
     */
    public boolean isReadStatus() {
        return readStatus;
    }

    /**
     * <p>
     * 获得引用消息信息
     * </p>
     *
     * @return {@link MessageInfo} 引用消息信息
     */
    public MessageInfo getQuote() {
        return quote;
    }

    /**
     * <p>
     * 获得引用特定用户或特定角色的信息
     * </p>
     *
     * @return {@link MessageMentionInfo} 引用特定用户或特定角色的信息
     */
    public MessageMentionInfo getMentionInfo() {
        return mentionInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageInfo that = (MessageInfo) o;
        return type == that.type && mentionAll == that.mentionAll && mentionHere == that.mentionHere && createAt == that.createAt && updatedAt == that.updatedAt && readStatus == that.readStatus && Objects.equals(id, that.id) && Objects.equals(content, that.content) && Objects.equals(mention, that.mention) && Objects.equals(mentionRoles, that.mentionRoles) && Objects.equals(embeds, that.embeds) && Objects.equals(reactions, that.reactions) && Objects.equals(author, that.author) && Objects.equals(imageName, that.imageName) && Objects.equals(quote, that.quote) && Objects.equals(mentionInfo, that.mentionInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, content, mention, mentionAll, mentionRoles, mentionHere, embeds, createAt, updatedAt, reactions, author, imageName, readStatus, quote, mentionInfo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MessageInfo.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("type=" + type)
                .add("content='" + content + "'")
                .add("mention=" + mention)
                .add("mentionAll=" + mentionAll)
                .add("mentionRoles=" + mentionRoles)
                .add("mentionHere=" + mentionHere)
                .add("embeds=" + embeds)
                .add("createAt=" + createAt)
                .add("updatedAt=" + updatedAt)
                .add("reactions=" + reactions)
                .add("author=" + author)
                .add("imageName='" + imageName + "'")
                .add("readStatus=" + readStatus)
                .add("quote=" + quote)
                .add("mentionInfo=" + mentionInfo)
                .toString();
    }
}
