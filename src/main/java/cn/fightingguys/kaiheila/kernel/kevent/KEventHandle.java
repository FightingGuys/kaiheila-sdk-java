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

import cn.fightingguys.kaiheila.kernel.config.KConfiguration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.charset.StandardCharsets;

/**
 * 消息信息核心处理
 *
 * @author running_hyk
 */
public final class KEventHandle {
    private KConfiguration configuration;
    private KEventListener eventListener;

    private Gson gson;
    private KSecurity security;

    /*
     *  拒绝无参数构造对象
     */
    private KEventHandle() {
    }

    /**
     * KProcessingCore 构造函数
     *
     * @param configuration 初始化配置
     * @param eventListener 消息回调监听器
     */
    public KEventHandle(KConfiguration configuration, KEventListener eventListener) {
        assert eventListener != null : "消息监听器不能为空";
        this.configuration = configuration;
        this.eventListener = eventListener;
        gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        security = new KSecurity(configuration.getEncryptKey(), configuration.getVerifyToken());
    }

    // todo 此函数作为过渡使用，等后续开放更多内容趋向稳定再做修改
    public String process(byte[] data) {
        KEventHandleContext context = new KEventHandleContext(configuration.isWebhookMode(), security, gson, data);
        context.handle();
        System.out.println(
                new String(context.getDebugRawByteArrayData(), StandardCharsets.UTF_8)
        );
        return eventListener.apply(context.getEvent());
    }

}
