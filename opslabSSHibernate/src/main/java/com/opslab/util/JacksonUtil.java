package com.opslab.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JacksonUtil {
	private static Logger logger = Logger.getLogger(JacksonUtil.class);

	private static ObjectMapper mapper = new ObjectMapper();
	static {
		// 将null值不序列化
		// objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		// 将null值转换为空串
		mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
			@Override
			public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
					throws IOException, JsonProcessingException {
				gen.writeString("");
			}
		});
	}

	public static String toJSON(Object object) {
		String json = "";
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.error("Jackson to json error :"+e.getMessage());
			json = toString(object);
		}
		return json;
	}

	public static String toString(Object object) {
		StringBuffer sbuf = new StringBuffer("{");
		java.lang.reflect.Field[] fields = object.getClass().getDeclaredFields();
		for (java.lang.reflect.Field f : fields) {
			String fieldName = f.getName();
			/*
			String value = String.valueOf(ClassUtil.getFieldValueByName(object,fieldName));
			if(value != null && !"".equals(value) && !"null".equals(value)){
				sbuf.append("\""+fieldName + "\":" + value+"\",");
			}
			*/
		}
		sbuf.replace(sbuf.length()-1, sbuf.length(), "}");
		return sbuf.toString();

	}
}
