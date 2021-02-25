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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 卡片信息上下文
 *
 * @see <a href="https://developer.kaiheila.cn/doc/cardmessage">卡片消息</a>
 */
public final class KMessageCardContext {

    private List<KMessageCard> cards = new ArrayList<>();

    public List<KMessageCard> getCards() {
        return cards;
    }

    public void setCards(List<KMessageCard> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KMessageCardContext that = (KMessageCardContext) o;
        return Objects.equals(cards, that.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    /**
     * 卡片消息建造者
     * 以编程语言方式快速构建卡片消息
     */
    public final static class Builder {

        /**
         * 卡片上下文
         */
        private final KMessageCardContext context;

        /**
         * 当前修改的卡片
         */
        private KMessageCard card;

        /**
         * 构造器
         */
        public Builder() {
            this.context = new KMessageCardContext();
            this.card = new KMessageCard();
        }

        /**
         * 结束当前卡片编辑
         *
         * @return 当前建筑者
         */
        public Builder submitCard() {
            context.getCards().add(card);
            card = null;
            return this;
        }

        /**
         * 创建新卡片
         * 如果当前卡片未提交将会自动提交
         *
         * @return 当前建筑者
         */
        public Builder newCard() {
            if (card != null) {
                submitCard();
            }
            card = new KMessageCard();
            return this;
        }


        public int getCurrentCardCount() {
            return context.cards.size();
        }
    }


}
