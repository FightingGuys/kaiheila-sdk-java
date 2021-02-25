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

package cn.fightingguys.kaiheila.kernel.kevent;

import cn.fightingguys.kaiheila.kernel.kevent.json.KMessageTypeJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/**
 * 事件消息类型枚举
 */
@JsonAdapter(KMessageTypeJsonAdapter.class)
public enum KMessageType {
    TEXT_MESSAGE("文字消息", 1),
    IMAGE_MESSAGE("图片消息", 2),
    VIDEO_MESSAGE("视频消息", 3),
    FILE_MESSAGE("文件消息", 4),
    VOICE_MESSAGE("音频消息", 8),
    K_MARKDOWN_MESSAGE("KMarkDown消息", 9),
    CARD_MESSAGE("卡片消息", 10),
    SYSTEM_MESSAGE("系统消息", 255),
    UNKNOWN_MESSAGE("未知消息", -1);

    /**
     * 事件名称
     */
    private final String name;

    /**
     * 事件代号
     */
    private final int typeCode;

    KMessageType(String name, int typeCode) {
        this.name = name;
        this.typeCode = typeCode;
    }

    public String getName() {
        return name;
    }

    public int getTypeCode() {
        return typeCode;
    }
}
