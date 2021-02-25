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

package cn.fightingguys.kaiheila.kernel.api.core;

public final class KApiBase {

    /**
     * 开黑啦接口基础地址
     *
     * @link https://developer.kaiheila.cn/doc/reference#%E5%B8%B8%E8%A7%84%20http%20%E6%8E%A5%E5%8F%A3%E8%A7%84%E8%8C%83
     */
    public final static String baseUrl = "https://www.kaiheila.cn/api";

    /* Http header Context-Type */
    public final static String contextTypeJson = "application/json";
    public final static String contextType = "Content-type";

    /* Http header Authorization */
    public final static String authorization = "Authorization";

}
