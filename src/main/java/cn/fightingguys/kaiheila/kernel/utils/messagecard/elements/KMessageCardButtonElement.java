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

import cn.fightingguys.kaiheila.kernel.utils.messagecard.KMessageCardThemeType;

public final class KMessageCardButtonElement extends KMessageCardElement {

    private KMessageCardThemeType theme;

    private String value;

    private String click;

    // todo 需修改 https://developer.kaiheila.cn/doc/cardmessage#%E5%85%83%E7%B4%A0
    private KMessageCardElement text;

    public KMessageCardButtonElement() {
        super(KMessageCardElementType.BUTTON);
    }

    public KMessageCardThemeType getTheme() {
        return theme;
    }

    public void setTheme(KMessageCardThemeType theme) {
        this.theme = theme;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public KMessageCardElement isText() {
        return text;
    }

    public void setText(KMessageCardElement text) {
        this.text = text;
    }

    public enum ClickType {
        /**
         * 不做任何处理
         */
        NULL(""),

        /**
         * 会跳转到value代表的链接
         */
        LINK("link"),

        /**
         * 返回点击用户id和value发回给发送者
         */
        RETURN_VAL("return-val");

        private final String type;

        ClickType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

    }

}
