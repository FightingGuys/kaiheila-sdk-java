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

package cn.fightingguys.kaiheila.service;

import cn.fightingguys.kaiheila.ApiServiceTests;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
import cn.fightingguys.kaiheila.api.service.GuildService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

public class GuildServiceTest {
    private static final GuildService guildService = ApiServiceTests.getServiceInstance().getGuildService();

    @Test
    public void listJoinedGuild() throws KHLAPIServiceException {
        System.out.println(
                guildService.listJoinedGuild()
        );
    }


}
