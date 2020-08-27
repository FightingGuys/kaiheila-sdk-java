/*
 *    Copyright 2020 FightingGuys Team
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

package cn.fightingguys.kaiheila.client.builder;

import cn.fightingguys.kaiheila.client.EBotApiVersion;
import cn.fightingguys.kaiheila.client.KHLBotClient;
import cn.fightingguys.kaiheila.client.impl.BotClientV1Impl;
import cn.fightingguys.kaiheila.config.SdkConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BotClientBuilder {

    private final SdkConfig sdkConfig;
    private String botToken;
    private Enum<EBotApiVersion> version = EBotApiVersion.v1;

    public BotClientBuilder(SdkConfig sdkConfig) {
        this.sdkConfig = sdkConfig;
    }

    public BotClientBuilder token(String botToken) {
        this.botToken = botToken;
        return this;
    }

    public BotClientBuilder apiVersion(Enum<EBotApiVersion> version) {
        this.version = version;
        return this;
    }

    public KHLBotClient build() {
        if (version == EBotApiVersion.v1) {
            return new BotClientV1Impl(this.sdkConfig, this.botToken);
        }
        return null;
    }

}
