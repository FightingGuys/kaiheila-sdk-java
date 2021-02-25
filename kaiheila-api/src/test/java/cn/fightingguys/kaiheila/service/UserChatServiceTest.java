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
import cn.fightingguys.kaiheila.api.core.KHLRestApiService;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
import cn.fightingguys.kaiheila.api.service.UserChatService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;


public class UserChatServiceTest {

    private static final KHLRestApiService service = ApiServiceTests.getServiceInstance();
    private static final UserChatService chatService = service.getUserChat();

    @Test
    public void listUserChat() throws KHLAPIServiceException {
        System.out.println(
                chatService.listUserChat()
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"","",""})
    public void viewUserChat(String chatCode) throws KHLAPIServiceException {
        System.out.println(
                chatService.viewUserChat(chatCode)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"","",""})
    public void createUserChat(String targetId) throws KHLAPIServiceException {
        System.out.println(
                chatService.createUserChat(targetId)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"","",""})
    public void deleteUserChat(String chatCode) throws KHLAPIServiceException {
        chatService.deleteUserChat(chatCode);
    }

    static Stream<Arguments> listMessageInputProvider(){
        return Stream.of(
                Arguments.arguments("","",""),
                Arguments.arguments("","","")
        );
    }
    @ParameterizedTest
    @MethodSource("listMessageInputProvider")
    public void listMessage(String chatCode,String msgId, String flag) throws KHLAPIServiceException {
        System.out.println(
                chatService.listMessage(chatCode,msgId,flag)
        );
    }

    static Stream<Arguments> sendMessageInputProvider(){
        return Stream.of(
                Arguments.arguments(0,"","","",""),
                Arguments.arguments(0,"","","","")
        );
    }
    @ParameterizedTest
    @MethodSource("sendMessageInputProvider")
    public void sendMessage(int type,
                            String chatCode,
                            String content,
                            String quote,
                            String nonce) throws KHLAPIServiceException {
        System.out.println(
                chatService.sendMessage(type, chatCode, content, quote, nonce)
        );
    }

    static Stream<Arguments> updateMessageInputProvider(){
        return Stream.of(
                Arguments.arguments(0,"",""),
                Arguments.arguments(0,"","")
        );
    }
    @ParameterizedTest
    @MethodSource("updateMessageInputProvider")
    public void updateMessage(int msgId,
                              String content,
                              String quote) throws KHLAPIServiceException {
        chatService.updateMessage(msgId, content, quote);
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    public void deleteMessage(String msgId) throws KHLAPIServiceException {
        chatService.deleteMessage(msgId);
    }

    static Stream<Arguments> listReactionInputProvider(){
        return Stream.of(
                Arguments.arguments("",""),
                Arguments.arguments("","")
        );
    }
    @ParameterizedTest
    @MethodSource("listReactionInputProvider")
    public void listReaction(String msgId,
                              String emoji) throws KHLAPIServiceException {
        System.out.println(
                chatService.listReaction(msgId, emoji)
        );
    }

    static Stream<Arguments> addReactionInputProvider(){
        return Stream.of(
                Arguments.arguments("",""),
                Arguments.arguments("","")
        );
    }
    @ParameterizedTest
    @MethodSource("addReactionInputProvider")
    public void addReaction(String msgId,
                             String emoji) throws KHLAPIServiceException {
        chatService.addReaction(msgId, emoji);
    }

    static Stream<Arguments> deleteReactionInputProvider(){
        return Stream.of(
                Arguments.arguments("",""),
                Arguments.arguments("","")
        );
    }
    @ParameterizedTest
    @MethodSource("deleteReactionInputProvider")
    public void deleteReaction(String msgId,
                            String emoji) throws KHLAPIServiceException {
        chatService.deleteReaction(msgId, emoji);
    }
}
