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

package cn.fightingguys.kaiheila.kernel.http;

import java.util.Map;

/**
 * Http 请求接口
 * 实现此接口可以，替换其他 Http 客户端模块
 */
public interface KHttpClient {

    /**
     * 设置 Http 请求地址
     *
     * @param url 请求地址
     */
    void url(String url);

    /**
     * 设置 Http 连接超时时间
     *
     * @param ms 时间长度 毫秒(ms)
     */
    void connectTimeout(int ms);

    /**
     * 设置 Http 读取超时时间
     *
     * @param ms 时间长度 毫秒(ms)
     */
    void readTimeout(int ms);

    /**
     * 设置 Http 请求方式
     *
     * @param method 请求方式
     */
    void method(KHttpMethod method);

    /**
     * 设置 Http 请求头
     *
     * @param header 请求头
     */
    void header(Map<String, String> header);

    /**
     * 设置 Http 参数
     * PathVariable
     *
     * @param param 参数
     */
    void param(Map<String, String> param);

    /**
     * 设置 Http Post 或 Put 方法的请求数据
     *
     * @param data 数据
     */
    void body(String data);

    /**
     * 发送请求
     */
    void send();

    /**
     * 获取 Http 返回状态码
     *
     * @return 状态码
     */
    int getStatusCode();

    /**
     * 获取 Http 返回结果内容
     *
     * @return http 内容
     */
    String getBody();

    /**
     * 获取 Http 返回结果头部
     *
     * @return key-value http 头
     */
    Map<String, String> getHeader();


    /**
     * 请求发生致命错误，抛出异常
     *
     * @return 发生致命错误
     */
    boolean fatalError();

    /**
     * 请求发生致命错误消息
     *
     * @return 致命错误消息
     */
    String getErrorMessage();

}
