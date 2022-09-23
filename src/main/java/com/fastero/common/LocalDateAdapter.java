package com.fastero.common;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
* Created by tao.zeng on 2020/6/23.
* <p>
* 处理LocalDate的序列化与反序列化
*/
public final class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    @Override
    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Override
    public LocalDate deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        String timestamp = element.getAsJsonPrimitive().getAsString();
        return LocalDate.parse(timestamp, DateTimeFormatter.ISO_LOCAL_DATE);
    }
}