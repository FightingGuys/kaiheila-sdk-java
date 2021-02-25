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

package cn.fightingguys.kaiheila.api.domain;

import java.util.Objects;
import java.util.StringJoiner;

public class ResponseEntity<DataT> {

    private int code;
    private String message;
    private DataT data;

    public ResponseEntity() {
    }

    /**
     * 错误码，0代表成功，非0代表失败，具体的错误码参见错误码一览
     *
     * @return 错误码
     */
    public int getCode() {
        return code;
    }

    /**
     * 错误消息，具体的返回消息会根据Accept-Language来返回。
     *
     * @return 错误消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 具体的数据
     *
     * @return 数据
     */
    public DataT getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseEntity<?> that = (ResponseEntity<?>) o;
        return code == that.code && Objects.equals(message, that.message) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, data);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ResponseEntity.class.getSimpleName() + "[", "]")
                .add("code=" + code)
                .add("message='" + message + "'")
                .add("data=" + data)
                .toString();
    }
}
