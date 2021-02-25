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

package cn.fightingguys.kaiheila.kernel.http.entity;

import java.util.Map;

/**
 * Http 返回结果实体类
 */
public final class KResponseEntity {

    private Map<String, String> header;
    private int code;
    private boolean timeout = false;
    private boolean fatalError = false;
    private String errorMessage;
    private String body;


    /**
     * 获取响应Header
     * @return Map<String, String>
     */
    public Map<String, String> getHeader() {
        return header;
    }


    /**
     * 设置响应Header
     * @param header
     */
    public void setHeader(Map<String, String> header) {
        this.header = header;
    }


    /**
     * 查看响应是否超时
     * @return boolean
     */
    public boolean isTimeout() {
        return timeout;
    }


    /**
     * 设置响应是否超时
     * @param timeout
     */
    public void setTimeout(boolean timeout) {
        this.timeout = timeout;
    }


    /**
     * 将响应设为超时
     */
    public void timeout() {
        this.timeout = true;
    }


    /**
     * 查看响应是否有Fatal Error
     * @return boolean
     */
    public boolean isFatalError() {
        return fatalError;
    }


    /**
     * 设置响应Fatal Error状态
     * @param fatalError
     */
    public void setFatalError(boolean fatalError) {
        this.fatalError = fatalError;
    }

    /**
     * 将响应设为Fatal Error状态
     */
    public void fatalError() {
        this.fatalError = true;
    }


    /**
     * 获得响应代码（如200成功）
     * @return int
     */
    public int getCode() {
        return code;
    }


    /**
     * 设置响应代码（如200成功）
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }


    /**
     * 获取响应错误信息
     * @return String
     */
    public String getErrorMessage() {
        return errorMessage;
    }


    /**
     * 设置响应错误信息
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * 获取响应Body
     * @return String
     */
    public String getBody() {
        return body;
    }


    /**
     * 设置响应Body
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }


    /**
     * 将响应输出为字符串
     * @return String
     */
    @Override
    public String toString() {
        return "KResponseEntity{" +
                "header=" + header +
                ", code=" + code +
                ", timeout=" + timeout +
                ", fatalError=" + fatalError +
                ", errorMessage='" + errorMessage + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
