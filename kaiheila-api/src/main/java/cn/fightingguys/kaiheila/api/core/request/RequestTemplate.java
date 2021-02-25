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

import cn.fightingguys.kaiheila.api.core.request.annotation.Pageable;
import cn.fightingguys.kaiheila.api.domain.PageEntity;
import cn.fightingguys.kaiheila.api.domain.ResponseEntity;
import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class RequestTemplate<T> extends ServiceMethod<T> {

    private final OkHttpClient client;
    private final ObjectMapper mapper;
    private final Method method;
    private final RequestFactory requestFactory;

    RequestTemplate(OkHttpClient client, ObjectMapper mapper, Method method, RequestFactory requestFactory) {
        this.client = client;
        this.mapper = mapper;
        this.method = method;
        this.requestFactory = requestFactory;
    }

    private static Type getTypeParametersByIndex(int index, Type type) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getActualTypeArguments()[index];
    }

    /**
     * @param args 调用服务的参数
     * @return 结果实体类
     * @throws Throwable 能抛出的异常
     */
    @Override
    @SuppressWarnings("unchecked")
    T invoke(Object[] args) throws Throwable {
        Call call = createNewCall(args);
        Response response = call.execute();

        ResponseBody responseBody = response.body();
        if (responseBody == null) {
            throw new KHLAPIServiceException("ResponseBody is null");
        }
        T result = null;
        if (response.isSuccessful()) {
            boolean pageable = (method.getAnnotation(Pageable.class) != null);
            JavaType jsonType = null;
            if (pageable) {
                Type returnParameterType = getTypeParametersByIndex(0, method.getGenericReturnType());
                JavaType returnType = mapper.getTypeFactory().constructType(returnParameterType);
                JavaType pageType = mapper.getTypeFactory().constructParametricType(PageEntity.class, returnType);
                jsonType = mapper.getTypeFactory().constructParametricType(ResponseEntity.class, pageType);
            } else {
                jsonType = mapper.getTypeFactory().constructParametricType(ResponseEntity.class, method.getReturnType());
            }
            ResponseEntity<T> responseEntity = mapper.readValue(responseBody.charStream(), jsonType);
            if (pageable)
                result = (T) ((PageEntity<?>) responseEntity.getData()).getItems();
            else
                result = responseEntity.getData();
        } else {
            throw new KHLAPIServiceException(responseBody.string());
        }
        return result;
    }

    private Call createNewCall(Object[] args) {
        return this.client.newCall(requestFactory.createRequest(args));
    }

}
