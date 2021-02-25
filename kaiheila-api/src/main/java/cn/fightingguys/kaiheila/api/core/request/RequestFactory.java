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

import cn.fightingguys.kaiheila.api.core.request.annotation.RequestBody;
import cn.fightingguys.kaiheila.api.core.request.annotation.*;
import okhttp3.*;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Objects;

import static okhttp3.MultipartBody.FORM;

/*
@RestRequest("v3/user/me") 表示需要可以被动态代理的请求函数（参数有 请求地址、请求方法）

@Query          作为地址的请求参数
@Path           请求地址占位符替换

@FormUrlEncoded 当使用 POST 请求时，将 Content-Type 设置为 x-www-form-urlencoded
@Field          当使用 POST 函数时，将这个变量转换成 x-www-form-urlencoded
@RequestBody    当使用 POST 函数时，将这个变量内容作为 POST 请求Body
@Multipart      当使用 POST 函数时

// 以下是扩展不属于 HTTP 内容
@Pageable       函数可以使用翻页功能  (https://developer.kaiheila.cn/doc/reference#接口格式及返回说明)
*/
public class RequestFactory {

    private final String baseUrl;
    private final Method method;

    private boolean multipartMode;
    private boolean formUrlEncodedMode;
    private boolean postMethod;

    RequestFactory(String baseUrl, Method method) {
        this.baseUrl = baseUrl;
        this.method = method;
    }

    /**
     * @param args 函数的参数数据
     * @return OkHttp3 请求
     */
    Request createRequest(Object[] args) {
        HttpUrl.Builder httpBuilder = Objects.requireNonNull(HttpUrl.parse(baseUrl)).newBuilder();
        RestRequest restRequest = method.getAnnotation(RestRequest.class);
        this.postMethod = (restRequest.method() == RestRequestService.HttpMethod.POST);
        this.multipartMode = (method.getAnnotation(Multipart.class) != null);
        this.formUrlEncodedMode = (method.getAnnotation(FormUrlEncoded.class) != null);

        String pathSegments = restRequest.value();
        Parameter[] parameters = method.getParameters();
        FormBody.Builder formBuilder = new FormBody.Builder();
        MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder();
        for (int i = 0; i < parameters.length; i++) {
            Annotation[] annotations = parameters[i].getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Path) {
                    String path = ((Path) annotation).value();
                    pathSegments = replacePlaceholder(pathSegments, path, args[i].toString());
                } else if (annotation instanceof Query) {
                    String paramKey = ((Query) annotation).value();
                    if (args[i] != null) {
                        httpBuilder.addQueryParameter(paramKey, args[i].toString());
                    }
                } else if (postMethod) {
                    if (formUrlEncodedMode) {
                        if (annotation instanceof Field) {
                            String fieldKey = ((Field) annotation).value();
                            if (args[i] != null) {
                                formBuilder.add(fieldKey, args[i].toString());
                            }
                        }
                    } else if (multipartMode) {
                        if (annotation instanceof RequestBody) {
                            String fieldKey = ((RequestBody) annotation).value();
                            if (args[i] instanceof File) {
                                File file = (File) args[i];
                                okhttp3.RequestBody requestBody = okhttp3.RequestBody.create(MediaType.parse("application/octet-stream"), file);
                                multipartBodyBuilder
                                        .setType(FORM)
                                        .addFormDataPart(fieldKey, file.getName(), requestBody);
                            } else {
                                throw new IllegalArgumentException("Must be File Type");
                            }
                        }
                    }
                }
            }
        }
        httpBuilder.addPathSegments(pathSegments);

        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(httpBuilder.build());
        if (postMethod) {
            if (formUrlEncodedMode) {
                requestBuilder.post(formBuilder.build());
            } else if (multipartMode) {
                requestBuilder.post(multipartBodyBuilder.build());
            }
        } else {
            requestBuilder.get();
        }
        return requestBuilder.build();
    }

    private String replacePlaceholder(String url, String placeholder, Object args) {
        return url.replaceAll("#\\{(" + placeholder + "?)}", (String) args);
    }

}
