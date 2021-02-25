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

package cn.fightingguys.kaiheila.kernel.oauth2;

/**
 * 权限掩码表 (Little-Endian)
 * 当 voiceChannel 和 textChannel 都为 true 时，为语音频道与文字频道通用权限 <br/>
 * 当 voiceChannel 和 textChannel 都为 false 时，为服务器通用权限 <br/>
 * 当 voiceChannel 和 textChannel 其一为 true 时，则为指定频道的专项权限 <br/>
 */
public enum KUserPermissionFlag {

    /* 通用权限 */
    /**
     * 管理员
     * 拥有此权限会获得完整的管理权，包括绕开所有其他权限（包括频道权限）限制，属于危险权限。
     */
    ADMINISTRATOR(1, false, false),

    /**
     * 管理服务器
     * 拥有此权限的成员可以修改服务器名称和更换区域。
     */
    MANAGE_GUILD(1 << 1, false, false),

    /**
     * 查看管理日志
     * 拥有此权限的成员可以查看服务器的管理日志。
     */
    VIEW_AUDIT_LOG(1 << 2, false, false),

    /**
     * 创建邀请
     * 拥有此权限的成员可以创建服务器邀请。
     */
    CREATE_INVITE(1 << 3, true, true),

    /**
     * 管理邀请
     * 拥有此权限的成员可以管理服务器邀请。
     */
    MANAGE_INVITE(1 << 4, true, true),


    /**
     * 频道管理
     * 拥有此权限的成员可以创建新的频道以及编辑或删除已存在的频道。
     */
    MANAGE_CHANNELS(1 << 5, true, true),

    /**
     * 踢出用户
     */
    KICK_MEMBERS(1 << 6, false, false),

    /**
     * 封禁用户
     */
    BAN_MEMBERS(1 << 7, false, false),

    /**
     * 管理自定义表情
     */
    MANAGE_EMOJIS(1 << 8, false, false),

    /**
     * 修改服务器昵称
     * 拥有此权限的用户可以更改他们的昵称。
     */
    CHANGE_NICKNAME(1 << 9, false, false),

    /**
     * 管理角色权限
     * 拥有此权限成员可以创建新的角色和编辑删除低于该角色的身份。
     */
    MANAGE_ROLES(1 << 10, true, true),

    /**
     * 查看文字、语音频道
     */
    VIEW_CHANNEL(1 << 11, true, true),

    /**
     * 修改他人昵称
     * 拥有此权限的用户可以更改他人的昵称
     */
    MANAGE_NICKNAMES(1 << 26, false, false),


    /* 文字权限 */
    /**
     * 发布消息
     */
    SEND_MESSAGES(1 << 12, false, true),

    /**
     * 管理消息
     * 拥有此权限的成员可以删除其他成员发出的消息和置顶消息。
     */
    MANAGE_MESSAGES(1 << 13, false, true),

    /**
     * 上传文件
     */
    ATTACH_FILES(1 << 14, false, true),

    /**
     * 提及@全体成员
     * 拥有此权限的成员可使用@全体成员以提及该频道中所有成员。
     */
    MENTION_EVERYONE(1 << 15, false, true),

    /**
     * 添加反应
     * 拥有此权限的成员可以对消息添加新的反应。
     */
    ADD_REACTIONS(1 << 18, false, true),

    /**
     * 跟随添加反应
     * 拥有此权限的成员可以跟随使用已经添加的反应。
     */
    FELLOW_REACTIONS(1 << 19, false, true),


    /* 语音权限 */
    /**
     * 语音连接
     */
    CONNECT(1 << 15, true, false),

    /**
     * 语音管理
     * 拥有此权限的成员可以把其他成员移动和踢出频道；但此类移动仅限于在该成员和被移动成员均有权限的频道之间进行。
     */
    MOVE_MEMBERS(1 << 16, true, false),

    /**
     * 被动连接语音频道
     * 拥有此限制的成员无法主动连接语音频道，只能在被动邀请或被人移动时，才可以进入语音频道。
     */
    PASSIVE_CONNECT(1 << 20, true, false),

    /**
     * 仅使用按键说话
     * 拥有此限制的成员加入语音频道后，只能使用按键说话。
     */
    USE_PRESS_VOICE(1 << 21, true, false),

    /**
     * 使用自由麦
     * 没有此权限的成员，必须在频道内使用按键说话。
     */
    USE_VAD(1 << 22, true, false),

    /**
     * 说话
     */
    SPEAK(1 << 23, true, false),

    /**
     * 服务器静音
     */
    DEAFEN_MEMBERS(1 << 24, true, false),

    /**
     * 服务器闭麦
     */
    MUTE_MEMBERS(1 << 25, true, false),

    /**
     * 播放伴奏
     * 拥有此权限的成员可在语音频道中播放音乐伴奏
     */
    PRIORITY_SPEAKER(1 << 27, true, false),
    ;
    private final long value;
    private final boolean voiceChannel;
    private final boolean textChannel;

    KUserPermissionFlag(long value, boolean voiceChannel, boolean textChannel) {
        this.value = value;
        this.voiceChannel = voiceChannel;
        this.textChannel = textChannel;
    }

    public long getValue() {
        return value;
    }

    public boolean isVoiceChannel() {
        return voiceChannel;
    }

    public boolean isTextChannel() {
        return textChannel;
    }

}
