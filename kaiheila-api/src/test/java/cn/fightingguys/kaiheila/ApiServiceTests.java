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

package cn.fightingguys.kaiheila;

import cn.fightingguys.kaiheila.api.core.KHLRestApiService;
import cn.fightingguys.kaiheila.api.core.KHLRestApiServiceV3Impl;
import cn.fightingguys.kaiheila.api.domain.*;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
import cn.fightingguys.kaiheila.api.service.MessageService;
import cn.fightingguys.kaiheila.core.KHLProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.netty.channel.Channel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApiServiceTests {
    private static final KHLProfile khlProfile = KHLProfile.builder().token("").build();
    private static final KHLRestApiService service = new KHLRestApiServiceV3Impl(khlProfile);

    public static KHLRestApiService getServiceInstance() {
        return service;
    }

    @Test
    public void testAllService() throws KHLAPIServiceException, JsonProcessingException {
    }

}
