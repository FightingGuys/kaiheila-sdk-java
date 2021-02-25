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

package cn.fightingguys.kaiheila.kernel.api.action.channel;

import cn.fightingguys.kaiheila.kernel.api.action.KIRequestAction;
import cn.fightingguys.kaiheila.kernel.api.action.KRequestAction;
import cn.fightingguys.kaiheila.kernel.http.KHttpMethod;
import cn.fightingguys.kaiheila.kernel.kevent.KMessageType;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class KMessageAction implements KIRequestAction {


    /**
     * @return KRequestAction
     */
    @Override
    public KRequestAction createRequest() {
        String body = new Gson().toJson(this);
        return new KRequestAction(KHttpMethod.POST, "/channel/message", body);
    }

    // todo 后续接口会有变动
    @SerializedName("type")
    private KMessageType messageType;

    @SerializedName("channel_id")
    private String channelId;

    private Object content;

    private String quote;

    private String nonce;


    /**
     * 设置消息类型
     * @param messageType 消息类型枚举
     */
    public void setMessageType(KMessageType messageType) {
        this.messageType = messageType;
    }


    /**
     * 设置消息频道ID
     * @param channelId 频道ID
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }


    /**
     * 设置消息内容
     * @param content 消息内容，与消息类型有关
     */
    public void setContent(Object content) {
        this.content = content;
    }


    /**
     * 设置引用消息ID
     * @param quote 引用的消息ID
     */
    public void setQuote(String quote) {
        this.quote = quote;
    }


    /**
     * 测试用
     * @param nonce
     */
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

}
