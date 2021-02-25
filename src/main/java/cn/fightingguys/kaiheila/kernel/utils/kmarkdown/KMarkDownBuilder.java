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

package cn.fightingguys.kaiheila.kernel.utils.kmarkdown;

import java.net.URL;

/**
 * 以编程语言的方式构建 KMarkDown 文本
 *
 * @link https://developer.kaiheila.cn/doc/kmarkdown
 */
public final class KMarkDownBuilder {

    private final StringBuilder builder = new StringBuilder();


    /**
     * 标记文字加粗区域
     *
     * @param text 需加粗的文字
     * @return 当前建筑者
     */
    public KMarkDownBuilder bold(String text) {
        if (!text.isEmpty()) {
            builder.append(String.format("**%s**", text));
        }
        return this;
    }


    /**
     * 标记文字斜体区域
     *
     * @param text 需斜体的文字
     * @return 当前建筑者
     */
    public KMarkDownBuilder italic(String text) {
        if (!text.isEmpty()) {
            builder.append(String.format("*%s*", text));
        }
        return this;
    }


    /**
     * 标记文字加粗斜体区域
     *
     * @param text 需加粗斜体的文字
     * @return 当前建筑者
     */
    public KMarkDownBuilder boldAndItalic(String text) {
        if (!text.isEmpty()) {
            builder.append(String.format("***%s***", text));
        }
        return this;
    }


    /**
     * 标记文字超链接区域，链接仅支持 (http://, https://)
     *
     * @param text 超链接文字说明
     * @param url  超链接地址
     * @return 当前建筑者
     */
    public KMarkDownBuilder link(String text, URL url) {
        if (!text.isEmpty() && url != null) {
            builder.append(String.format("[%s](%s)", text, url.toExternalForm()));
        }
        return this;
    }


    /**
     * 标记文字超链接区域，链接仅支持 (http://, https://)
     *
     * @param text 超链接文字说明
     * @param link 超链接地址
     * @return 当前建筑者
     */
    public KMarkDownBuilder link(String text, String link) {
        if (!text.isEmpty() && !link.isEmpty()) {
            builder.append(String.format("[%s](%s)", text, link));
        }
        return this;
    }


    /**
     * 标记分割栏
     *
     * @return 当前建筑者
     */
    public KMarkDownBuilder separationLine() {
        builder.append("---");
        return this;
    }


    /**
     * 标记文字引用区域
     *
     * @param text 需引用的文字
     * @return 当前建筑者
     */
    public KMarkDownBuilder quote(String text) {
        if (!text.isEmpty()) {
            builder.append("> ").append(text);
        }
        return this;
    }


    /**
     * 标记文字下划线区域
     *
     * @param text 需下划线的文字
     * @return 当前建筑者
     */
    public KMarkDownBuilder underLine(String text) {
        if (!text.isEmpty()) {
            builder.append(String.format("(ins)%s(ins)", text));
        }
        return this;
    }


    /**
     * 标记文字隐藏区域
     * 内容默认是遮住的，只有用户点击才会显示
     *
     * @param text 需隐藏的文字
     * @return 当前建筑者
     * @see public KMarkDownBuilder#spoiler(String)
     */
    public KMarkDownBuilder hidden(String text) {
        return spoiler(text);
    }


    /**
     * 标记文字禁止剧透区域
     * 内容默认是遮住的，只有用户点击才会显示
     *
     * @param text 需禁止剧透的文字
     * @return 当前建筑者
     * @see public KMarkDownBuilder#spoiler(String)
     */
    public KMarkDownBuilder spoiler(String text) {
        if (!text.isEmpty()) {
            builder.append(String.format("(spl)%s(spl)", text));
        }
        return this;
    }


    /**
     * 标记 Emoji 区域
     * 基本与 emoji 的 shortcode 写法保持一致
     *
     * @param emoji shortcode 代号
     * @return 当前建筑者
     * @see <a href="https://www.webfx.com/tools/emoji-cheat-sheet/"> EMOJI ShortCode 列表 </a>
     */
    // todo 后续考虑检测 Emoji ShortCode 是否正确
    public KMarkDownBuilder emoji(String emoji) {
        if (!emoji.isEmpty()) {
            if (emoji.charAt(0) == ':' && emoji.charAt(emoji.length() - 1) == ':') {
                /* 用户提交带有 :: (双冒号时，自动以不补全方式提交) */
                builder.append(emoji);
            } else {
                builder.append(String.format(":%s:", emoji));
            }
        }
        return this;
    }


    /**
     * 标记 服务器表情 区域
     * 服务器表情，需要有服务器发送服务器表情的权限
     *
     * @param emojiName 服务器表情名
     * @param guildId   服务器id
     * @return 当前建筑者
     */
    public KMarkDownBuilder guildEmoji(String emojiName, String guildId) {
        if (!emojiName.isEmpty() && !guildId.isEmpty()) {
            builder.append(String.format("(emj)%s(emj)[%s]", emojiName, guildId));
        }
        return this;
    }


    /**
     * 标记 提及频道
     *
     * @param channelId 需要提及 频道Id
     * @return 当前建筑者
     */
    public KMarkDownBuilder metChannel(String channelId) {
        if (!channelId.isEmpty()) {
            builder.append(String.format("(chn)%s(chn)", channelId));
        }
        return this;
    }


    /**
     * 标记 提及用户
     *
     * @param userId 需要提及 用户Id
     * @return 当前建筑者
     */
    public KMarkDownBuilder metUser(String userId) {
        if (!userId.isEmpty()) {
            builder.append(String.format("(met)%s(met)", userId));
        }
        return this;
    }


    /**
     * 标记 提及当前在线用户
     *
     * @return 当前建筑者
     */
    public KMarkDownBuilder metHere() {
        return metUser("here");
    }


    /**
     * 标记 提及所有用户
     *
     * @return 当前建筑者
     */
    public KMarkDownBuilder metAll() {
        return metUser("all");
    }


    /**
     * 标记 提及某角色所有用户
     *
     * @param roleId 需要提及 角色Id
     * @return 当前建筑者
     */
    public KMarkDownBuilder metRole(String roleId) {
        if (!roleId.isEmpty()) {
            builder.append(String.format("(rol)%s(rol)", roleId));
        }
        return this;
    }


    /**
     * 标记 行内代码
     *
     * @param code 需要标记行内代码
     * @return 当前建筑者
     */
    public KMarkDownBuilder inlineCode(String code) {
        if (!code.isEmpty()) {
            builder.append(String.format("`%s`", code));
        }
        return this;
    }


    /**
     * 标记 代码块
     *
     * @param language 编程语言名称
     * @param code     需要标记行内代码
     * @return 当前建筑者
     */
    public KMarkDownBuilder codeBlock(String language, String code) {
        if (!language.isEmpty() && !code.isEmpty()) {
            builder.append(String.format("```%s\n%s\n```", language, code));
        }
        return this;
    }


    /**
     * 标记换行
     *
     * @return 当前建造者
     */
    public KMarkDownBuilder newLine() {
        builder.append('\n');
        return this;
    }


    /**
     * 转成 kMarkDown 字符串内容
     *
     * @return 转码 kMarkDown 字符串内容
     */
    @Override
    public String toString() {
        return builder.toString();
    }

}
