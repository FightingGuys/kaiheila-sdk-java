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

import cn.fightingguys.kaiheila.kernel.utils.messagecard.elements.KMessageCardElement;

public final class KMessageCardSectionModule extends KMessageCardModule {

    private AccessoryMode mode;

    private KMessageCardElement text;

    private KMessageCardElement accessory;

    public KMessageCardSectionModule() {
        super(KMessageCardModuleType.SECTION);
    }

    public AccessoryMode getMode() {
        return mode;
    }

    public void setMode(AccessoryMode mode) {
        this.mode = mode;
    }

    public KMessageCardElement getText() {
        return text;
    }

    public void setText(KMessageCardElement text) {
        this.text = text;
    }

    public KMessageCardElement getAccessory() {
        return accessory;
    }

    public void setAccessory(KMessageCardElement accessory) {
        this.accessory = accessory;
    }

    public enum AccessoryMode {

        LEFT("left"),
        RIGHT("right");

        private final String mode;

        AccessoryMode(String mode) {
            this.mode = mode;
        }

        public String getMode() {
            return mode;
        }
    }

}
