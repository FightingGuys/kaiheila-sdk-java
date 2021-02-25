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
import cn.fightingguys.kaiheila.api.core.request.annotation.Multipart;
import cn.fightingguys.kaiheila.api.core.request.annotation.RequestBody;
import cn.fightingguys.kaiheila.api.core.request.annotation.RestRequest;
import cn.fightingguys.kaiheila.api.domain.RemoteURL;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;

import java.io.File;

/**
 * 媒体模块
 *
 * @link https://developer.kaiheila.cn/doc/http/asset
 */
public interface AssetService {

    /**
     * 上传文件/图片
     *
     * @return {@link RemoteURL} 服务器返回的url
     * @throws {@link KHLAPIServiceException}
     */
    @Multipart
    @RestRequest(value = "v3/asset/create", method = RestRequestService.HttpMethod.POST)
    RemoteURL createAsset(@RequestBody("file") File file) throws KHLAPIServiceException;
}
