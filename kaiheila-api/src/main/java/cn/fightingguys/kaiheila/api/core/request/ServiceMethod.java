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

package cn.fightingguys.kaiheila.api.core.request;

import cn.fightingguys.kaiheila.api.core.request.annotation.RestRequest;

import java.lang.reflect.Method;

abstract class ServiceMethod<T> {

    static <T> ServiceMethod<T> parseAnnotations(RestRequestService requestService, Method method) {
        RestRequest annotation = method.getAnnotation(RestRequest.class);
        if (annotation == null) {
            throw new IllegalArgumentException(method.getName() + " must have RestRequest annotation.");
        }
        RequestFactory factory = new RequestFactory(requestService.getBaseUrl(), method);
        return new RequestTemplate<>(requestService.getClient(), requestService.getMapper(), method, factory);
    }

    abstract T invoke(Object[] args) throws Throwable;

}
