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
import cn.fightingguys.kaiheila.api.service.IntimacyService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class IntimacyServiceTest {
    private static final IntimacyService intimacyService = ApiServiceTests.getServiceInstance().getIntimacyService();

    @ParameterizedTest
    @ValueSource(strings = "")
    public void getUserIntimacy(String userId) throws KHLAPIServiceException {
        System.out.println(
                intimacyService.getUserIntimacy(userId)
        );
    }

    static Stream<Arguments> updateUserIntimacyInputProvider() {
        return Stream.of(
                Arguments.arguments("", 0, "", 0),
                Arguments.arguments("", 0, "", 0)
        );
    }
    @ParameterizedTest
    @MethodSource("updateUserIntimacyInputProvider")
    public void updateUserIntimacy(String userId,
                                   int score,
                                   String socialInfo,
                                   int imgId) throws KHLAPIServiceException {
        intimacyService.updateUserIntimacy(userId, score, socialInfo, imgId);
    }
}
