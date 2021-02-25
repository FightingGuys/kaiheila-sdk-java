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
import cn.fightingguys.kaiheila.api.service.MessageService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class MessageServiceTest {

    private static final MessageService messageService = ApiServiceTests.getServiceInstance().getMessageService();

    static Stream<Arguments> listChannelMessageInputProvider() {
        return Stream.of(
                Arguments.arguments("", "", 0, ""),
                Arguments.arguments("", "", 0, "")
        );
    }
    @ParameterizedTest
    @MethodSource("listChannelMessageInputProvider")
    public void listChannelMessage(String channelId,
                                   String msgId,
                                   long pin,
                                   String flag) throws KHLAPIServiceException {
        System.out.println(
                messageService.listChannelMessage(channelId, msgId, pin, flag)
        );
    }

    static Stream<Arguments> sendMessageInputProvider() {
        return Stream.of(
                Arguments.arguments(0, "", "", "", "", ""),
                Arguments.arguments(0, "", "", "", "", "")
        );
    }
    @ParameterizedTest
    @MethodSource("sendMessageInputProvider")
    public void sendMessage(int type,
                            String channelId,
                            String content,
                            String quote,
                            String nonce,
                            String tempTargetId) throws KHLAPIServiceException {
        System.out.println(
                messageService.sendMessage(type, channelId, content, quote, nonce, tempTargetId)
        );
    }

    static Stream<Arguments> updateMessageInputProvider() {
        return Stream.of(
                Arguments.arguments("", "", ""),
                Arguments.arguments("", "", "")
        );
    }
    @ParameterizedTest
    @MethodSource("updateMessageInputProvider")
    public void updateMessage(String msgId,
                              String content,
                              String quote) throws KHLAPIServiceException {

        messageService.updateMessage(msgId, content, quote);
    }

    @ParameterizedTest
    @ValueSource(strings = "")
    public void deleteMessage(String msgId) throws KHLAPIServiceException {

        messageService.deleteMessage(msgId);
    }

    static Stream<Arguments> listReactionInputProvider() {
        return Stream.of(
                Arguments.arguments("", ""),
                Arguments.arguments("", "")
        );
    }
    @ParameterizedTest
    @MethodSource("listReactionInputProvider")
    public void listReaction(String msgId,
                             String emoji) throws KHLAPIServiceException {
        System.out.println(messageService.listReaction(msgId,emoji));
    }

    static Stream<Arguments> addReactionInputProvider() {
        return Stream.of(
                Arguments.arguments("", ""),
                Arguments.arguments("", "")
        );
    }
    @ParameterizedTest
    @MethodSource("addReactionInputProvider")
    public void addReaction(String msgId,
                            String emoji) throws KHLAPIServiceException {
        messageService.addReaction(msgId,emoji);
    }

    static Stream<Arguments> deleteReactionInputProvider() {
        return Stream.of(
                Arguments.arguments("", ""),
                Arguments.arguments("", "")
        );
    }
    @ParameterizedTest
    @MethodSource("deleteReactionInputProvider")
    public void deleteReaction(String msgId,
                               String emoji,
                               String userId) throws KHLAPIServiceException {
        messageService.deleteReaction(msgId, emoji, userId);
    }
}
