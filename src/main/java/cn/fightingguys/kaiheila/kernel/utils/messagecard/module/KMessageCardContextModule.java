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

import cn.fightingguys.kaiheila.kernel.utils.messagecard.elements.KMessageCardButtonElement;
import cn.fightingguys.kaiheila.kernel.utils.messagecard.elements.KMessageCardElement;

import java.util.ArrayList;
import java.util.List;

public final class KMessageCardContextModule extends KMessageCardModule {

    private final List<KMessageCardElement> elements = new ArrayList<>();

    public KMessageCardContextModule() {
        super(KMessageCardModuleType.CONTEXT);
    }

    public List<KMessageCardElement> getElements() {
        return elements;
    }

    public KMessageCardContextModule imageElement(KMessageCardButtonElement element) {
        if (elements.size() == 10) {
            throw new ArrayIndexOutOfBoundsException("单个交互组模块不允许超过 10 个元素");
        } else {
            elements.add(element);
        }
        return this;
    }
}
