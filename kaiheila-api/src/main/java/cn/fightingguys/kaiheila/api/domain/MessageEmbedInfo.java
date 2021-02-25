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

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(
        {@JsonSubTypes.Type(value = MessageEmbedLinkInfo.class, name = "link"),
                @JsonSubTypes.Type(value = MessageEmbedBiliVideoInfo.class, name = "bili-video")})
public class MessageEmbedInfo implements Serializable {

    private String type;

    public MessageEmbedInfo() {
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEmbedInfo that = (MessageEmbedInfo) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MessageEmbedInfo.class.getSimpleName() + "[", "]")
                .add("type='" + type + "'")
                .toString();
    }
}
