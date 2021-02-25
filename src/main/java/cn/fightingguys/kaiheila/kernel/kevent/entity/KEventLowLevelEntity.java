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

import cn.fightingguys.kaiheila.kernel.kevent.KSignallingType;
import com.google.gson.annotations.SerializedName;

/**
 * 事件低层实体类
 */
public final class KEventLowLevelEntity {

    /**
     * WebSocket 模式信令
     *
     * @link https://developer.kaiheila.cn/doc/websocket#%E4%BF%A1%E4%BB%A4%E6%A0%BC%E5%BC%8F
     */
    @SerializedName("s")
    private KSignallingType signalling;

    /**
     * 当信令为 0 时，sn 才会开始计数
     * 消息序列 ( 0 ~ 4,294,967,295 )
     *
     * @see KEventLowLevelEntity#signalling
     */
    private long sn;

    public KSignallingType getSignalling() {
        return signalling;
    }

    public void setSignalling(KSignallingType signalling) {
        this.signalling = signalling;
    }

    public long getSn() {
        return sn;
    }

    public void setSn(long sn) {
        this.sn = sn;
    }
}
