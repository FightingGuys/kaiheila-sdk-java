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

package cn.fightingguys.kaiheila.kernel.api.ratelimit;

public enum KRateLimiterPriority {

    /**
     * 最高优先级
     */
    HIGHEST,

    /**
     * 较高优先级
     */
    HIGHER,

    /**
     * 正常优先级
     */
    NORMAL,

    /**
     * 较低优先级
     */
    LOWER,

    /**
     * 最低优先级
     */
    LOWEST

}
