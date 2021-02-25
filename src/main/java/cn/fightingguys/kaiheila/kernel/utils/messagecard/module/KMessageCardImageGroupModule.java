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

import cn.fightingguys.kaiheila.kernel.utils.messagecard.elements.KMessageCardImageElement;

import java.util.ArrayList;
import java.util.List;

public final class KMessageCardImageGroupModule extends KMessageCardModule {

    private final List<KMessageCardImageElement> elements = new ArrayList<>();

    public KMessageCardImageGroupModule() {
        super(KMessageCardModuleType.IMAGE);
    }

    public List<KMessageCardImageElement> getElements() {
        return elements;
    }

    public KMessageCardImageGroupModule imageElement(KMessageCardImageElement element) {
        if (elements.size() == 9) {
            throw new ArrayIndexOutOfBoundsException("单个图片组模块不允许超过 9 个元素");
        } else {
            elements.add(element);
        }
        return this;
    }
}
