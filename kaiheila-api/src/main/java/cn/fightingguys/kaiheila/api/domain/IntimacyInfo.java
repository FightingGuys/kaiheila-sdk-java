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

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class IntimacyInfo {

    private String imgUrl;
    private String socialInfo;
    private long lastModify;
    private int lastRead;
    private int score;
    private List<IntimacyImageInfo> imgList;

    public IntimacyInfo() {
    }

    /**
     * <p>
     * 获得机器人给用户显示的形象图片地址
     * </p>
     *
     * @return 机器人给用户显示的形象图片地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * <p>
     * 获得机器人显示给用户的社交信息
     * </p>
     *
     * @return 机器人显示给用户的社交信息
     */
    public String getSocialInfo() {
        return socialInfo;
    }

    /**
     * <p>
     * 获得用户上次修改的时间戳
     * </p>
     *
     * @return 用户上次修改的时间戳
     */
    public long getLastModify() {
        return lastModify;
    }

    /**
     * <p>
     * 获得用户上次查看的时间戳
     * </p>
     *
     * @return 用户上次查看的时间戳
     */
    public int getLastRead() {
        return lastRead;
    }

    /**
     * <p>
     * 获得亲密度，0-2200
     * </p>
     *
     * @return 亲密度
     */
    public int getScore() {
        return score;
    }

    /**
     * <p>
     * 获得形象图片的总列表
     * </p>
     *
     * @return {@link IntimacyImageInfo} 形象图片的总列表
     */
    public List<IntimacyImageInfo> getImgList() {
        return imgList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntimacyInfo that = (IntimacyInfo) o;
        return lastModify == that.lastModify && lastRead == that.lastRead && score == that.score && Objects.equals(imgUrl, that.imgUrl) && Objects.equals(socialInfo, that.socialInfo) && Objects.equals(imgList, that.imgList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imgUrl, socialInfo, lastModify, lastRead, score, imgList);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IntimacyInfo.class.getSimpleName() + "[", "]")
                .add("imgUrl='" + imgUrl + "'")
                .add("socialInfo='" + socialInfo + "'")
                .add("lastModify=" + lastModify)
                .add("lastRead=" + lastRead)
                .add("score=" + score)
                .add("imgList=" + imgList)
                .toString();
    }
}
