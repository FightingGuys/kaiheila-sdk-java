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

package cn.fightingguys.kaiheila.kernel.utils.messagecard;

import cn.fightingguys.kaiheila.kernel.utils.messagecard.module.KMessageCardModule;

import java.util.ArrayList;
import java.util.List;

/**
 * 卡片消息
 *
 * @see <a href="https://developer.kaiheila.cn/doc/cardmessage">卡片消息</a>
 */
public final class KMessageCard {

    private final String type = "card";
    private final List<KMessageCardModule> modules = new ArrayList<>();
    private String color;
    private KMessageCardThemeType themeType;
    private KMessageCardSizeType sizeType;

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public KMessageCardThemeType getThemeType() {
        return themeType;
    }

    public KMessageCardSizeType getSizeType() {
        return sizeType;
    }

    public List<KMessageCardModule> getModules() {
        return modules;
    }

    public static class Builder {

        private final KMessageCard card = new KMessageCard();

        public Builder module(KMessageCardModule module) {
            if (card.modules.size() == 50) {
                throw new ArrayIndexOutOfBoundsException("单个卡片不允许超过 50 个模块");
            } else {
                card.modules.add(module);
            }
            return this;
        }

        /**
         * 卡片颜色 RGB色彩空间
         *
         * @param r 红色通道 取值范围 [0, 255]
         * @param g 绿色通道 取值范围 [0, 255]
         * @param b 蓝色通道 取值范围 [0, 255]
         * @return 当前建筑者
         */
        public Builder colorOfRgbInteger(int r, int g, int b) {
            if ((r >= 0 && r <= 255) && (g >= 0 && g <= 255) && (b >= 0 && b <= 255)) {
                card.color = "#" + Integer.toHexString(r) +
                        Integer.toHexString(g) +
                        Integer.toHexString(b);
            } else {
                throw new NumberFormatException("卡片颜色 int取值范围不在 [0, 255] ");
            }
            return this;
        }

        /**
         * 卡片颜色 RGB色彩空间
         *
         * @param r 红色通道 取值范围 [0, 1]
         * @param g 绿色通道 取值范围 [0, 1]
         * @param b 蓝色通道 取值范围 [0, 1]
         * @return 当前建筑者
         */
        public Builder colorOfRgbFloat(float r, float g, float b) {
            if ((r >= 0.f && r <= 1.f) && (g >= 0.f && g <= 1.f) && (b >= 0.f && b <= 1.f)) {
                colorOfRgbInteger((int) r * 255, (int) g * 255, (int) b * 255);
            } else {
                throw new NumberFormatException("卡片颜色 float取值范围不在 [0, 1] ");
            }
            return this;
        }

        public Builder themeType(KMessageCardThemeType themeType) {
            card.themeType = themeType;
            return this;
        }

        public Builder sizeType(KMessageCardSizeType sizeType) {
            card.sizeType = sizeType;
            return this;
        }

        public KMessageCard build() {
            return card;
        }
    }

}
