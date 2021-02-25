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

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

public final class JacksonRequestConverter {
    public static <T> T convert(ObjectMapper mapper, Reader reader, Type type) throws IOException {
        JavaType javaType = mapper.getTypeFactory().constructType(type);
        ObjectReader objectReader = mapper.readerFor(javaType);
        try {
            return objectReader.readValue(reader);
        } finally {
            reader.close();
        }
    }
}
