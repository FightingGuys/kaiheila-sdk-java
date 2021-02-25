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

package cn.fightingguys.kaiheila.kernel.utils.messagecard.module;

/**
 * 卡片消息模块类型
 *
 * @see <a href="https://developer.kaiheila.cn/doc/cardmessage#%E6%A8%A1%E5%9D%97">模块类型</a>
 */
public enum KMessageCardModuleType {

    /* Context */
    HEADER("header"),
    SECTION("section"),
    IMAGE("image-group"),
    ACTION("action-group"),
    CONTEXT("context"),
    DIVIDER("divider"),

    /* File */
    FILE("file"),
    AUDIO("audio"),
    VIDEO("video"),

    /* Count Down */
    COUNTDOWN("countdown");

    private final String type;

    KMessageCardModuleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
