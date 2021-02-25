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

package cn.fightingguys.kaiheila.api.service;

import cn.fightingguys.kaiheila.api.core.request.RestRequestService;
import cn.fightingguys.kaiheila.api.core.request.annotation.Field;
import cn.fightingguys.kaiheila.api.core.request.annotation.FormUrlEncoded;
import cn.fightingguys.kaiheila.api.core.request.annotation.Query;
import cn.fightingguys.kaiheila.api.core.request.annotation.RestRequest;
import cn.fightingguys.kaiheila.api.domain.IntimacyInfo;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;

/**
 * 亲密度
 */
public interface IntimacyService {

    /**
     * 获取用户亲密度
     *
     * @param userId 用户的 id
     * @return {@link IntimacyInfo}
     * @throws KHLAPIServiceException
     */
    @RestRequest("v3/intimacy/index")
    IntimacyInfo getUserIntimacy(@Query("user_id") String userId) throws KHLAPIServiceException;

    /**
     * 更新用户亲密度
     *
     * @param userId     用户的 id
     * @param score      亲密度，0-2200
     * @param socialInfo 机器人与用户的社交信息，500 字以内
     * @param imgId      id必须在用户亲密度接口返回的 img_list 中
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/intimacy/update", method = RestRequestService.HttpMethod.POST)
    void updateUserIntimacy(@Field("user_id") String userId,
                            @Field("score") int score,
                            @Field("social_info") String socialInfo,
                            @Field("img_id") int imgId) throws KHLAPIServiceException;

}
