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

import cn.fightingguys.kaiheila.kernel.utils.messagecard.elements.KMessageCardPlainTextElement;

public final class KMessageCardHeaderModule extends KMessageCardModule {

    private KMessageCardPlainTextElement text;

    public KMessageCardHeaderModule() {
        super(KMessageCardModuleType.HEADER);
    }

    public KMessageCardPlainTextElement getTextElement() {
        return text;
    }

    public void setTextElement(KMessageCardPlainTextElement textElement) {
        this.text = textElement;
    }
}
