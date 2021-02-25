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

import java.util.Objects;
import java.util.StringJoiner;

public class MessageEmbedBiliVideoInfo extends MessageEmbedInfo {

    private String url;
    private String origin_url;
    private String avNo;
    private String iframePath;
    private String duration;
    private String title;
    private String pic;

    public MessageEmbedBiliVideoInfo() {
    }

    public String getUrl() {
        return url;
    }

    public String getOrigin_url() {
        return origin_url;
    }

    public String getAvNo() {
        return avNo;
    }

    public String getIframePath() {
        return iframePath;
    }

    public String getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public String getPic() {
        return pic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MessageEmbedBiliVideoInfo that = (MessageEmbedBiliVideoInfo) o;
        return Objects.equals(url, that.url) && Objects.equals(origin_url, that.origin_url) && Objects.equals(avNo, that.avNo) && Objects.equals(iframePath, that.iframePath) && Objects.equals(duration, that.duration) && Objects.equals(title, that.title) && Objects.equals(pic, that.pic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), url, origin_url, avNo, iframePath, duration, title, pic);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MessageEmbedBiliVideoInfo.class.getSimpleName() + "[", "]")
                .add("url='" + url + "'")
                .add("origin_url='" + origin_url + "'")
                .add("avNo='" + avNo + "'")
                .add("iframePath='" + iframePath + "'")
                .add("duration='" + duration + "'")
                .add("title='" + title + "'")
                .add("pic='" + pic + "'")
                .toString();
    }
}
