package com.cf.data.model.poloniex;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Elroy on 18-6-2017.
 */
public class LocalDateTimeSerializer  implements JsonSerializer<LocalDateTime> {

	@Override
	public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return new JsonPrimitive(localDateTime.format(formatter));
	}
}
