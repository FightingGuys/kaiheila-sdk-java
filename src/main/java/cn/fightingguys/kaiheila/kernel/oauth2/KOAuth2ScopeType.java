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

package cn.fightingguys.kaiheila.kernel.oauth2;

/**
 * 邀请链接
 *
 * @link https://developer.kaiheila.cn/bot/oauth
 */
public enum KOAuth2ScopeType {

    /**
     * 允许读取服务器基本信息
     */
    GUILDS("guilds"),
    /**
     * 允许机器人邀请用户加入服务器
     */
    GUILDS_JOIN("guilds.join"),
    /**
     * 允许机器人读取文字信息
     */
    MESSAGES_READ("messages.read"),
    /**
     * 允许机器人收集用户的好友关系-仅限白名单
     */
    RELATIONSHIPS_READ("relationships.read");

    private final String value;

    KOAuth2ScopeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(KOAuth2ScopeType scope) {
        return this.getValue().equals(scope.getValue());
    }

}
