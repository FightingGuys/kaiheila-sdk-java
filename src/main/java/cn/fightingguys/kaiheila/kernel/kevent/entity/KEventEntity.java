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

import java.io.Serializable;

/**
 * 消息事件对象
 *
 * @link https://developer.kaiheila.cn/doc/event
 */
public abstract class KEventEntity implements Serializable {
    /**
     * 事件频道类型
     */
    @SerializedName("channel_type")
    private String channelType;

    /**
     * 事件消息类型
     */
    private KMessageType type;

    /**
     * webhook 模式独有数据字段
     */
    @SerializedName("verify_token")
    private String verifyToken;

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public KMessageType getType() {
        return type;
    }

    public void setType(KMessageType type) {
        this.type = type;
    }

    public String getVerifyToken() {
        return verifyToken;
    }

    public void setVerifyToken(String verifyToken) {
        this.verifyToken = verifyToken;
    }
}
