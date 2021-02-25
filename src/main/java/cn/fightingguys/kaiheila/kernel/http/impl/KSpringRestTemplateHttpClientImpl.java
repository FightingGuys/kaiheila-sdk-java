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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * KHttpClient实现类
 * Spring Http Client
 */
public class KSpringRestTemplateHttpClientImpl implements KHttpClient {

    private final SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
    private final RestTemplate restTemplate = new RestTemplate(httpRequestFactory);

    /* Request */
    private final HttpHeaders headers = new HttpHeaders();
    private final Map<String, String> params = new HashMap<>();
    private String url;
    private HttpMethod method;
    private String postBody;

    /* Response */
    private ResponseEntity<String> responseEntity = null;
    private String errorMessage;
    private boolean fatalError;


    /* Http Request Interface */

    @Override
    public void url(String url) {
        this.url = url;
    }

    @Override
    public void connectTimeout(int ms) {
        httpRequestFactory.setConnectTimeout(ms);
    }

    @Override
    public void readTimeout(int ms) {
        httpRequestFactory.setReadTimeout(ms);
    }

    @Override
    public void method(KHttpMethod method) {
        this.method = HttpMethod.resolve(method.name());
    }

    @Override
    public void header(Map<String, String> header) {
        header.forEach(this.headers::add);
    }

    @Override
    public void param(Map<String, String> param) {
        param.forEach(this.params::put);
    }

    @Override
    public void body(String data) {
        this.postBody = data;
    }

    @Override
    public void send() {
        HttpEntity<String> entity = new HttpEntity<>(postBody, headers);
        try {
            responseEntity = restTemplate.exchange(url, method, entity, String.class, params);
        } catch (RestClientResponseException e) {
            this.errorMessage = e.getMessage();
            responseEntity = new ResponseEntity<>(e.getResponseBodyAsString(), e.getResponseHeaders(), e.getRawStatusCode());
        } catch (RestClientException e) {
            this.errorMessage = e.getMessage();
            fatalError = true;
        }
    }


    /* Http Response Interface */

    @Override
    public int getStatusCode() {
        return responseEntity.getStatusCodeValue();
    }

    @Override
    public String getBody() {
        return responseEntity.getBody();
    }

    @Override
    public Map<String, String> getHeader() {
        return responseEntity.getHeaders().toSingleValueMap();
    }

    @Override
    public boolean fatalError() {
        return fatalError;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
