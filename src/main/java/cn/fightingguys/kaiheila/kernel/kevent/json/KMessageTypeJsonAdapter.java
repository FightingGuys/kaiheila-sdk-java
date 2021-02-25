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

import cn.fightingguys.kaiheila.kernel.kevent.KMessageType;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Optional;

public final class KMessageTypeJsonAdapter implements JsonSerializer<KMessageType>, JsonDeserializer<KMessageType> {

    @Override
    public KMessageType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Optional<KMessageType> eventType = Arrays.stream(KMessageType.values()).parallel().filter(it -> it.getTypeCode() == json.getAsInt()).findFirst();
        return eventType.orElse(KMessageType.UNKNOWN_MESSAGE);
    }

    @Override
    public JsonElement serialize(KMessageType src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getTypeCode());
    }
}
