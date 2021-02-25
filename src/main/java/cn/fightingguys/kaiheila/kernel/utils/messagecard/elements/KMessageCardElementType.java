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

package cn.fightingguys.kaiheila.kernel.utils.messagecard.elements;

/**
 * 卡片消息元素类型
 *
 * @see <a href="https://developer.kaiheila.cn/doc/cardmessage#%E5%85%83%E7%B4%A0">元素类型</a>
 */
public enum KMessageCardElementType {

    /* Context */
    PLAIN("plain-text"),
    K_MARKDOWN("kmarkdown"),
    IMAGE("image"),
    BUTTON("button");

    private final String type;

    KMessageCardElementType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
