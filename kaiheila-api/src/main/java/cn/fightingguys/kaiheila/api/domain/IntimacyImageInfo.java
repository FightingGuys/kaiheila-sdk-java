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

public class IntimacyImageInfo implements Serializable {

    private String id;

    private String url;

    public IntimacyImageInfo() {
    }

    /**
     * <p>
     * 获得形象图片的id
     * </p>
     *
     * @return 形象图片的id
     */
    public String getId() {
        return id;
    }

    /**
     * <p>
     * 获得形象图片的地址
     * </p>
     *
     * @return 形象图片的地址
     */
    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntimacyImageInfo that = (IntimacyImageInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IntimacyImageInfo.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("url='" + url + "'")
                .toString();
    }
}
