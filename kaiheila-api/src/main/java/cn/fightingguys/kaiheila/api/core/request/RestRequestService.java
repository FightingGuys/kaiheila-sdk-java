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

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;

public class RestRequestService {

    private final static HashMap<Method, ServiceMethod<?>> methodCache = new HashMap<>();
    private final String baseUrl;
    private final OkHttpClient client;
    private final ObjectMapper mapper;

    private RestRequestService(String baseUrl, OkHttpClient client, ObjectMapper mapper) {
        this.baseUrl = baseUrl;
        this.client = client;
        this.mapper = mapper;
    }

    private static void validateBaseUrl(String baseUrl) {
        char c = baseUrl.charAt(baseUrl.length() - 1);
        assert c == '/' : "The end of base url must be /";
    }

    /*
     * KHLRestApiServiceV3Impl 是一个 API 服务的实现类，所有的服务都在那里创建，后面会写成 Lazy Load 减少不必要的类加载。
     *
     * cn.fightingguys.kaiheila.api.service 是一个接口服务的包
     * 以下是服务的生成流程：
     * 在 KHLRestApiServiceV3Impl 创建新的服务
     *
     * RestRequestService.createRestService(
     *       RequestTemplate client,  // 请求OkHttp3客户端以及数据转换服务 jackson-databind
     *       final Class<T> restRequestClass  // 需要生成服务接口的类
     * );
     *
     *  // 这个 createRestService 函数就是下面的，实际就是创建一个动态代理实例 Proxy.newProxyInstance
     *  this.userService = RestRequestService.createRestService(client, UserService.class);
     *
     * 使用这个框架的用户（开发者），就直接访问接口，接口的实现类其实就是动态代理。
     * 动态代理的工作就是为了完成，一个 接口实现类 的工作。
     *
     *
     * @RestRequest("v3/user/me")
     * UserInfo getMeUser() throws KHLAPIServiceException;
     *
     * 通过动态代理，java 会给我们传递每一条被调用的函数信息，我们可以通过信息去创建一个 OkHttp3.Request
     * 再通过 RequestTemplate 为我们发送请求，然后再将 JSON/XML数据 ，转换成Java POJO实体类。
     *
     *
     * 整体设计有些复杂，但是写好之后无论官方改动多少，我们只需要维护接口上的 注解(annotation)，即可完成所有 API 请求任务
     * */

    public static RestRequestService createRequestTemplate(String baseUrl, OkHttpClient client, ObjectMapper mapper) {
        return new RestRequestService(baseUrl, client, mapper);
    }

    private static <T> void checkSafeInterfaceClass(Class<T> clazz) throws IllegalArgumentException {
        if (!clazz.isInterface()) {
            throw new IllegalArgumentException(clazz.getName() + ".class must be interfaces.");
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T createRestService(final Class<T> restRequestClass) throws IllegalArgumentException {
        checkSafeInterfaceClass(restRequestClass);
        return (T) Proxy.newProxyInstance(
                restRequestClass.getClassLoader(),
                new Class<?>[]{restRequestClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        if (method.getDeclaringClass() == Object.class) {
                            return method.invoke(this, args);
                        }
                        args = (args != null) ? args : Collections.emptyList().toArray();
                        return loadServiceMethod(method).invoke(args);
                    }
                });
    }

    private ServiceMethod<?> loadServiceMethod(Method method) {
        ServiceMethod<?> result = methodCache.get(method);
        if (result != null) return result;
        synchronized (methodCache) {
            result = methodCache.get(method);
            if (result == null) {
                result = ServiceMethod.parseAnnotations(this, method);
                methodCache.put(method, result);
            }
        }
        return result;
    }

    OkHttpClient getClient() {
        return client;
    }

    ObjectMapper getMapper() {
        return mapper;
    }

    String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Hypertext Transfer Protocol Method
     * <a href="https://tools.ietf.org/html/rfc2616#section-5.1.1">rfc2616</a>
     */
    public enum HttpMethod {
        /* http 1.0 */
        GET,
        POST,

//        /* http 1.1 */
//        OPTIONS,
//        HEAD,
//        PUT,
//        DELETE,
//        TRACE,
//        CONNECT
    }
}
