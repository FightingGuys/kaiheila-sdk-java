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

package cn.fightingguys.kaiheila.client.impl;

import cn.fightingguys.kaiheila.client.KHLBotClient;
import cn.fightingguys.kaiheila.config.SdkConfig;

public class BotClientV1Impl extends KHLBotClient {
    public BotClientV1Impl(SdkConfig sdkConfig, String token) {
        this.setToken(token);
    }

    @Override
    public final String getVersion() {
        return "KHL BotClient4J v1.0.0";
    }
}
