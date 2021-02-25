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
import cn.fightingguys.kaiheila.api.domain.GuildEmojiInfo;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;

import java.io.File;
import java.util.List;

public interface GuildEmoji {

    /**
     * 获取服务器表情列表
     *
     * @param guildId 服务器的id
     * @return {@link GuildEmojiInfo}
     * @throws KHLAPIServiceException
     */
    @RestRequest("v3/guild-emoji/index")
    List<GuildEmojiInfo> listGuildEmoji(@Query("guild_id") String guildId) throws KHLAPIServiceException;

    /**
     * 创建服务器表情
     *
     * @param name     表情名。长度限制 2 - 32 字符，如果不写，则为随机字符串
     * @param guild_id 服务器 ID
     * @param file     表情文件。必须为 PNG 类型，大小不能超过 256 KB
     * @return {@link GuildEmojiInfo}
     * @throws KHLAPIServiceException
     */
    //todo emoji file posting
    @FormUrlEncoded
    @RestRequest(value = "v3/guild-emoji/create", method = RestRequestService.HttpMethod.POST)
    GuildEmojiInfo createGuildEmoji(@Field("name") String name,
                                    @Field("guild_id") String guild_id,
                                    @Field("emoji") File file) throws KHLAPIServiceException;

    /**
     * 更新服务器表情
     *
     * @param name 表情名。长度限制 2 - 32 字符，如果不写，则为随机字符串
     * @param id   表情 ID
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/guild-emoji/update", method = RestRequestService.HttpMethod.POST)
    void updateGuildEmoji(@Field("name") String name,
                          @Field("id") String id) throws KHLAPIServiceException;

    /**
     * 删除服务器表情
     *
     * @param id 表情 ID
     * @throws KHLAPIServiceException
     */
    @FormUrlEncoded
    @RestRequest(value = "v3/guild-emoji/delete", method = RestRequestService.HttpMethod.POST)
    void deleteGuildEmoji(@Field("id") String id) throws KHLAPIServiceException;

}
