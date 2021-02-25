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

package cn.fightingguys.kaiheila.kernel.kevent.entity;

import cn.fightingguys.kaiheila.kernel.kevent.KMessageType;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 事件消息扩展对象
 * https://developer.kaiheila.cn/doc/event#%E4%BA%8B%E4%BB%B6%E4%B8%BB%E8%A6%81%E6%A0%BC%E5%BC%8F
 */
public final class KEventExtraDataEntity {

    /**
     * 消息频道类型
     */
    private KMessageType type;

    /**
     * 服务器 id
     */
    @SerializedName("guild_id")
    private String guildId;

    /**
     * 频道名
     */
    @SerializedName("channel_name")
    private String channelName;

    /**
     * 提及到的用户 id 的列表
     */
    private List<String> mention;

    /**
     * mention (at) 所有用户
     */
    @SerializedName("mention_all")
    private boolean mentionAll;

    /**
     * mention (at) 用户角色的列表
     */
    @SerializedName("mention_roles")
    private List<Integer> mentionRoles;

    /**
     * mention (at) 在线用户
     */
    @SerializedName("mention_here")
    private boolean mentionHere;

    /**
     * 发送者用户信息
     *
     * @see KEventMessageEntity
     */
    private KEventExtraAuthorEntity author;

    /**
     * 被引用消息
     */
    //todo 临时使用 KEventMessageEntity 作为引用对象，官方未有确认该类型
    private KEventMessageEntity quote;

    public KMessageType getType() {
        return type;
    }

    public void setType(KMessageType type) {
        this.type = type;
    }

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public List<String> getMention() {
        return mention;
    }

    public void setMention(List<String> mention) {
        this.mention = mention;
    }

    public boolean isMentionAll() {
        return mentionAll;
    }

    public void setMentionAll(boolean mentionAll) {
        this.mentionAll = mentionAll;
    }

    public List<Integer> getMentionRoles() {
        return mentionRoles;
    }

    public void setMentionRoles(List<Integer> mentionRoles) {
        this.mentionRoles = mentionRoles;
    }

    public boolean isMentionHere() {
        return mentionHere;
    }

    public void setMentionHere(boolean mentionHere) {
        this.mentionHere = mentionHere;
    }

    public KEventExtraAuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(KEventExtraAuthorEntity author) {
        this.author = author;
    }

    public KEventMessageEntity getQuote() {
        return quote;
    }

    public void setQuote(KEventMessageEntity quote) {
        this.quote = quote;
    }
}
