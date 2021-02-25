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

import com.google.gson.annotations.SerializedName;

/**
 * 消息事件系统消息对象
 *
 * @link https://developer.kaiheila.cn/doc/event#%E4%BA%8B%E4%BB%B6%E4%B8%BB%E8%A6%81%E6%A0%BC%E5%BC%8F
 */
public final class KEventMessageEntity extends KEventEntity {

    /**
     * 发送目的 id，如果为是 GROUP 消息，则 target_id 代表频道 id
     */
    @SerializedName("target_id")
    private String targetId;

    /**
     * 发送者 id, 1 代表系统
     */
    @SerializedName("author_id")
    private String authorId;

    /**
     * 消息内容, 文件，图片，视频时，content 为 url
     */
    private String content;

    /**
     * 消息的 id
     */
    @SerializedName("msg_id")
    private String msgId;

    /**
     * 消息发送时间的毫秒时间戳
     */
    @SerializedName("msg_timestamp")
    private long msgTimestamp;

    /**
     * 随机串，与用户消息发送 api 中传的 nonce 保持一致
     */
    private String nonce;

    /**
     * 不同的消息类型，结构不一致
     */
    // todo 扩展数据
    private KEventExtraDataEntity extra;


    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public long getMsgTimestamp() {
        return msgTimestamp;
    }

    public void setMsgTimestamp(long msgTimestamp) {
        this.msgTimestamp = msgTimestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public KEventExtraDataEntity getExtra() {
        return extra;
    }

    public void setExtra(KEventExtraDataEntity extra) {
        this.extra = extra;
    }
}
