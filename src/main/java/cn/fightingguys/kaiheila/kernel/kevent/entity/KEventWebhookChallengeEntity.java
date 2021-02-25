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

package cn.fightingguys.kaiheila.kernel.kevent.entity;

/**
 * 消息事件 WEBHOOK_CHALLENGE 消息对象
 *
 * @link https://developer.kaiheila.cn/doc/event#%E4%BA%8B%E4%BB%B6%E4%B8%BB%E8%A6%81%E6%A0%BC%E5%BC%8F
 */
public final class KEventWebhookChallengeEntity extends KEventEntity {

    /**
     * 回调地址返回数据验证数据
     *
     * @link https://developer.kaiheila.cn/doc/webhook#%E9%85%8D%E7%BD%AE%E5%9B%9E%E8%B0%83%E5%9C%B0%E5%9D%80
     */
    private String challenge;

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }
}
