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

package cn.fightingguys.kaiheila.kernel.kevent.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Set;

/**
 * 事件 extra author 对象
 *
 * @link https://developer.kaiheila.cn/doc/event#%E4%BA%8B%E4%BB%B6%E4%B8%BB%E8%A6%81%E6%A0%BC%E5%BC%8F
 */
public final class KEventExtraAuthorEntity implements Serializable {

    /**
     * 用户 id
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户在当前服务器的昵称
     */
    private String nickname;

    /**
     * 用户名 # 后的 4 位识别 id
     */
    @SerializedName("identify_num")
    private String identifyNum;

    /**
     * 用户在线状态
     */
    private boolean online;

    /**
     * 头像图片地址
     */
    private String avatar;

    /**
     * 用户在当前服务器中的角色 id 组成的列表
     */
    private Set<Integer> roles;

    /**
     * 是否是机器人
     */
    private boolean bot;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIdentifyNum() {
        return identifyNum;
    }

    public void setIdentifyNum(String identifyNum) {
        this.identifyNum = identifyNum;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<Integer> getRoles() {
        return roles;
    }

    public void setRoles(Set<Integer> roles) {
        this.roles = roles;
    }

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

}
