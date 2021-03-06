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

package cn.fightingguys.kaiheila.kernel.kevent.json;

import cn.fightingguys.kaiheila.kernel.kevent.KSignallingType;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Optional;

public final class KSignallingTypeJsonAdapter implements JsonSerializer<KSignallingType>, JsonDeserializer<KSignallingType> {

    @Override
    public KSignallingType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Optional<KSignallingType> eventType = Arrays.stream(KSignallingType.values()).parallel().filter(it -> it.getType() == json.getAsInt()).findFirst();
        return eventType.orElse(KSignallingType.UNKNOWN);
    }

    @Override
    public JsonElement serialize(KSignallingType src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getType());
    }
}
