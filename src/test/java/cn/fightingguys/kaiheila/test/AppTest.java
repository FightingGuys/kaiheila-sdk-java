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

package cn.fightingguys.kaiheila.test;

import cn.fightingguys.kaiheila.client.KHLBotClient;
import cn.fightingguys.kaiheila.client.builder.BotClientBuilder;
import cn.fightingguys.kaiheila.config.JsonConfigLoader;
import cn.fightingguys.kaiheila.config.SdkConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class AppTest {

    @Test
    public void echoTest() {
        SdkConfig sdkConfig = new JsonConfigLoader("settings.json").load();
        KHLBotClient khlClient = new BotClientBuilder(sdkConfig)
                .token("4sqPyQQ7QjkqNxABHQAAtEIgASgBMAk4A0DwkwlYAWBfcAKAAQGIAQGdAQAAgD-oAQGwAYCt4gS4AV_FAS2ynT4")
                .build();
    }

}
