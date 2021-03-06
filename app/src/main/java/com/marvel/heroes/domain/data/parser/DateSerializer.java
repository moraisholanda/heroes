package com.marvel.heroes.domain.data.parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sergio on 19/06/16.
 */
public class DateSerializer implements JsonSerializer<Date> {
    SimpleDateFormat simpleDateFormat;

    public DateSerializer(String serializeDateFormat) {
        simpleDateFormat = new SimpleDateFormat(serializeDateFormat);
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(simpleDateFormat.format(src));
    }
}
