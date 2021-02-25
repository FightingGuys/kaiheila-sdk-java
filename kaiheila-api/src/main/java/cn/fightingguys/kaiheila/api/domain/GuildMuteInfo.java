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

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class GuildMuteInfo implements Serializable {

    @JsonProperty("1")
    private List<String> micMute;

    @JsonProperty("2")
    private List<String> headsetMute;

    public GuildMuteInfo() {
    }

    /**
     * 麦克风静音用户 Id
     *
     * @return 用户ID列表
     */
    public List<String> getMicMute() {
        return micMute;
    }

    /**
     * 耳机静音用户 Id
     *
     * @return 用户ID列表
     */
    public List<String> getHeadsetMute() {
        return headsetMute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuildMuteInfo that = (GuildMuteInfo) o;
        return Objects.equals(micMute, that.micMute) && Objects.equals(headsetMute, that.headsetMute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(micMute, headsetMute);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GuildMuteInfo.class.getSimpleName() + "[", "]")
                .add("micMute=" + micMute)
                .add("headsetMute=" + headsetMute)
                .toString();
    }
}
