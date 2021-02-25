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

package cn.fightingguys.kaiheila.api.core.request.annotation;

import cn.fightingguys.kaiheila.api.core.request.RestRequestService;

import java.lang.annotation.*;

/**
 * API 请求函数
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RestRequest {

    /**
     * @return 请求地址
     */
    String value() default "";

    /**
     * @return 请求方法
     * @see RestRequestService.HttpMethod
     */
    RestRequestService.HttpMethod method() default RestRequestService.HttpMethod.GET;

}
