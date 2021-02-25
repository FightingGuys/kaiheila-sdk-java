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

package cn.fightingguys.kaiheila.kernel.http.impl;

import cn.fightingguys.kaiheila.kernel.http.KHttpClient;
import cn.fightingguys.kaiheila.kernel.http.KHttpMethod;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 没有任何依赖的 Java原生 HttpClient，不推荐使用
 */
public class KJavaNativeHttpClientImpl implements KHttpClient {

    private final Map<String, String> header = new HashMap<>();
    private final Map<String, String> responseHeader = new HashMap<>();
    private String url;
    private int connectTimeout;
    private int readTimeout;
    private String method;
    private String queryString;
    private String postBody;
    private boolean fatalError;
    private String errorMessage;
    private int code;
    private String body;

    public String encoding(String val) {
        String result = null;
        try {
            result = URLEncoder.encode(val, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void url(String url) {
        this.url = url;
    }

    @Override
    public void connectTimeout(int ms) {
        this.connectTimeout = ms;
    }

    @Override
    public void readTimeout(int ms) {
        this.readTimeout = ms;
    }

    @Override
    public void method(KHttpMethod method) {
        this.method = method.name();
    }

    @Override
    public void header(Map<String, String> header) {
        header.forEach(this.header::put);
    }

    @Override
    public void param(Map<String, String> param) {
        StringBuilder builder = new StringBuilder();
        param.forEach((k, v) -> builder.append('&').append(encoding(k)).append('=').append(encoding(v)));
        builder.replace(0, 1, "?");
        this.queryString = builder.toString();
    }

    @Override
    public void body(String data) {
        this.postBody = data;
    }

    @Override
    public void send() {
        String fullUrl = url + queryString;
        HttpURLConnection connection;
        try {
            connection = (HttpURLConnection) new URL(fullUrl).openConnection();
        } catch (IOException e) {
            errorMessage = e.getMessage();
            fatalError = true;
            return;
        }

        header.forEach(connection::setRequestProperty);
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);

        if (method.equals("POST") || method.equals("PUT")) {
            connection.setDoOutput(true);
            OutputStream outputStream;
            try {
                outputStream = connection.getOutputStream();
                outputStream.write(postBody.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                errorMessage = e.getMessage();
                fatalError = true;
                return;
            }
        } else {
            try {
                connection.connect();
            } catch (IOException e) {
                errorMessage = e.getMessage();
                fatalError = true;
                return;
            }
        }

        try {
            this.code = connection.getResponseCode();
        } catch (IOException e) {
            errorMessage = e.getMessage();
            fatalError = true;
            return;
        }
        connection.getHeaderFields().forEach((k, vs) -> this.responseHeader.put(k, vs.get(0)));

        StringBuilder builder = new StringBuilder();
        try {
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                builder.append(str);
            }
            inputStream.close();
        } catch (IOException e) {
            errorMessage = e.getMessage();
            fatalError = true;
            return;
        }
        body = builder.toString();
    }

    @Override
    public int getStatusCode() {
        return this.code;
    }

    @Override
    public String getBody() {
        return this.body;
    }

    @Override
    public Map<String, String> getHeader() {
        return this.responseHeader;
    }

    @Override
    public boolean fatalError() {
        return this.fatalError;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
