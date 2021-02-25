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

package cn.fightingguys.kaiheila.api.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class GuildInfo implements Serializable {

    private String id;
    private String name;
    private String topic;
    private String masterId;
    private boolean isMaster;
    private String icon;
    private int inviteEnabled;
    private int notifyType;
    private String region;
    private int enableOpen;
    private String openId;
    private String defaultChannelId;
    private String welcomeChannelId;

    public GuildInfo() {
    }

    /**
     * <p>
     * 获得服务器id
     * </p>
     *
     * @return 服务器id
     */
    public String getId() {
        return id;
    }

    /**
     * <p>
     * 获得服务器名称
     * </p>
     *
     * @return 服务器名称
     */
    public String getName() {
        return name;
    }

    /**
     * <p>
     * 获得服务器主题
     * </p>
     *
     * @return 服务器主题
     */
    public String getTopic() {
        return topic;
    }

    /**
     * <p>
     * 获得服务器主的id
     * </p>
     *
     * @return 服务器主的id
     */
    public String getMasterId() {
        return masterId;
    }

    /**
     * <p>
     * 当前用户是否为服务器主
     * </p>
     *
     * @return 当前用户是否为服务器主
     */
    public boolean isMaster() {
        return isMaster;
    }

    /**
     * <p>
     * 获得服务器icon的地址
     * </p>
     *
     * @return 服务器icon的地址
     */
    public String getIcon() {
        return icon;
    }

    /**
     * <p>
     * 是否开启邀请
     * </p>
     *
     * @return 是否开启邀请
     */
    public int getInviteEnabled() {
        return inviteEnabled;
    }

    /**
     * <p>
     * 获得通知类型, 0代表默认使用服务器通知设置，1代表接收所有通知, 2代表仅@被提及，3代表不接收通知
     * </p>
     *
     * @return 通知类型
     */
    public int getNotifyType() {
        return notifyType;
    }

    /**
     * <p>
     * 获得服务器默认使用语言区域
     * </p>
     *
     * @return 服务器默认使用语言区域
     */
    public String getRegion() {
        return region;
    }

    /**
     * <p>
     * 是否为公开服务器
     * </p>
     *
     * @return 是否为公开服务器
     */
    public int getEnableOpen() {
        return enableOpen;
    }

    /**
     * <p>
     * 获得公开服务器id
     * </p>
     *
     * @return 公开服务器id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * <p>
     * 获得默认频道id
     * </p>
     *
     * @return 默认频道id
     */
    public String getDefaultChannelId() {
        return defaultChannelId;
    }

    /**
     * <p>
     * 获得欢迎频道id
     * </p>
     *
     * @return 欢迎频道id
     */
    public String getWelcomeChannelId() {
        return welcomeChannelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuildInfo guildInfo = (GuildInfo) o;
        return isMaster == guildInfo.isMaster && inviteEnabled == guildInfo.inviteEnabled && notifyType == guildInfo.notifyType && enableOpen == guildInfo.enableOpen && Objects.equals(id, guildInfo.id) && Objects.equals(name, guildInfo.name) && Objects.equals(topic, guildInfo.topic) && Objects.equals(masterId, guildInfo.masterId) && Objects.equals(icon, guildInfo.icon) && Objects.equals(region, guildInfo.region) && Objects.equals(openId, guildInfo.openId) && Objects.equals(defaultChannelId, guildInfo.defaultChannelId) && Objects.equals(welcomeChannelId, guildInfo.welcomeChannelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, topic, masterId, isMaster, icon, inviteEnabled, notifyType, region, enableOpen, openId, defaultChannelId, welcomeChannelId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GuildInfo.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("topic='" + topic + "'")
                .add("masterId='" + masterId + "'")
                .add("isMaster=" + isMaster)
                .add("icon='" + icon + "'")
                .add("inviteEnabled=" + inviteEnabled)
                .add("notifyType=" + notifyType)
                .add("region='" + region + "'")
                .add("enableOpen=" + enableOpen)
                .add("openId='" + openId + "'")
                .add("defaultChannelId='" + defaultChannelId + "'")
                .add("welcomeChannelId='" + welcomeChannelId + "'")
                .toString();
    }
}
