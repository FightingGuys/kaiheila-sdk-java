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

public class MessageEmbedLinkInfo extends MessageEmbedInfo {

    private String url;
    private String title;
    private String description;
    private String siteName;
    private String themeColor;
    private String image;

    public MessageEmbedLinkInfo() {
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MessageEmbedLinkInfo that = (MessageEmbedLinkInfo) o;
        return Objects.equals(url, that.url) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(siteName, that.siteName) && Objects.equals(themeColor, that.themeColor) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), url, title, description, siteName, themeColor, image);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MessageEmbedLinkInfo.class.getSimpleName() + "[", "]")
                .add("url='" + url + "'")
                .add("title='" + title + "'")
                .add("description='" + description + "'")
                .add("siteName='" + siteName + "'")
                .add("themeColor='" + themeColor + "'")
                .add("image='" + image + "'")
                .toString();
    }
}
