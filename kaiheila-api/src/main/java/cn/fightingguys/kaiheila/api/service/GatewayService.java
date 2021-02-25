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

import cn.fightingguys.kaiheila.api.core.request.annotation.Query;
import cn.fightingguys.kaiheila.api.core.request.annotation.RestRequest;
import cn.fightingguys.kaiheila.api.domain.RemoteURL;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;

public interface GatewayService {

    /**
     * 获取网关连接地址
     *
     * @param compress 下发数据是否压缩，默认为1,代表压缩
     * @return {@link RemoteURL} 网关的连接地址
     * @throws {@link KHLAPIServiceException}
     */
    @RestRequest("v3/gateway/index")
    RemoteURL getWebSocketGateway(@Query("compress") int compress) throws KHLAPIServiceException;

}
