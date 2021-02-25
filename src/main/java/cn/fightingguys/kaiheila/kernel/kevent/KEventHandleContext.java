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

import cn.fightingguys.kaiheila.kernel.kevent.compression.KCompression;
import cn.fightingguys.kaiheila.kernel.kevent.compression.impl.KZLibCompression;
import cn.fightingguys.kaiheila.kernel.kevent.entity.*;
import com.google.gson.reflect.TypeToken;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 消息事件处理上下文
 */
public final class KEventHandleContext {

    /**
     * webhook
     */
    private boolean webhookMode;

    /**
     * 外部传入数据
     */
    private byte[] data;

    /**
     * 事件低层实体
     */
    private KEventLowLevelEntity eventLowLevel;

    /**
     * 事件数据解析元数据实体
     */
    private KEventMetaDataEntity eventMetaData;

    /**
     * 解析后的事件数据对象
     */
    private KEventEntity eventEntity;

    /**
     * 信息安全模块
     */
    private KSecurity security;

    /**
     * Json 序列化以及反序列化模块
     */
    private Gson gson;

    private KEventHandleContext() {
    }

    protected KEventHandleContext(boolean webhookMode, KSecurity security, Gson gson, byte[] data) {
        this.webhookMode = webhookMode;
        this.security = security;
        this.gson = gson;
        this.data = data;
    }

    /**
     * 数据处理
     */
    protected void handle() {
        decompress();
        decryption();
        parseEventMetaData();
        verifyData();
        analysis();
    }

    /**
     * 数据压缩检测与解压
     */
    protected void decompress() {
        final KCompression compression = new KZLibCompression();
        if (compression.checkValidFormat(data)) {
            try {
                data = compression.decompress(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 数据密文检测与解密
     */
    protected void decryption() {
        final KSecurity.AesCipher cipher = security.new AesCipher();
        if (cipher.isEncryptData(data)) {
            try {
                data = cipher.decrypt(cipher.getEncryptData());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    /**
     * webhook 模式独有
     * 验证数据真伪
     */
    protected void verifyData() {
        if (webhookMode) {
            if (!security.verify(eventMetaData)) {
                throw new SecurityException("Webhook Verify 验证失败，检查是否存在恶意攻击");
            }
        }
    }

    /**
     * 解析事件消息元数据
     */
    protected void parseEventMetaData() {
        String json = new String(data, StandardCharsets.UTF_8);

        /* 低层数据解析 */
        eventLowLevel = gson.fromJson(json, KEventLowLevelEntity.class);

        /* 事件数据解析 */
        JsonElement d = JsonParser.parseString(json).getAsJsonObject().get("d"); // d
        eventMetaData = gson.fromJson(d, KEventMetaDataEntity.class);
    }

    /**
     * 解析事件数据对应类实体
     */
    protected void analysis() {
        //todo 事件分析处理
        String json = new String(data, StandardCharsets.UTF_8);
        JsonObject d = JsonParser.parseString(json).getAsJsonObject().getAsJsonObject("d"); // d

        if (eventMetaData.getType() == KMessageType.UNKNOWN_MESSAGE) {
            eventEntity = new KEventUnknownTypeEntity();
            ((KEventUnknownTypeEntity) eventEntity).setObjectMap(gson.fromJson(d, new TypeToken<Map<String, Object>>() {
            }.getType()));
            return;
        }

        if (eventMetaData.getChannelType().equalsIgnoreCase("WEBHOOK_CHALLENGE")) {
            eventEntity = gson.fromJson(d, KEventWebhookChallengeEntity.class);
            return;
        }

        eventEntity = gson.fromJson(d, KEventMessageEntity.class);
    }

    /**
     * 获取解析事件消息对象
     *
     * @return 事件消息对象
     */
    public KEventEntity getEvent() {
        return eventEntity;
    }

    /**
     * 获取低层实例对象，WebSocket 信令 以及 消息序列
     *
     * @return 低层实例对象
     */
    public KEventLowLevelEntity getEventLowLevel() {
        return eventLowLevel;
    }

    // todo 仅在开发中使用，后续公开后需要删除此接口
    public byte[] getDebugRawByteArrayData() {
        return data;
    }
}
