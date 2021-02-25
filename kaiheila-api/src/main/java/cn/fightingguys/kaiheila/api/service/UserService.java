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

import cn.fightingguys.kaiheila.api.core.request.annotation.RestRequest;
import cn.fightingguys.kaiheila.api.domain.UserInfo;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;

/**
 * 用户相关接口
 */
public interface UserService {

    /**
     * <p>
     * 获取当前登录的用户的信息
     * </p>
     *
     * @return {@see MeUser} 机器人信息
     * @throws KHLAPIServiceException 用户调用异常
     */
    @RestRequest("v3/user/me")
    UserInfo getMeUserInfo() throws KHLAPIServiceException;

}
