package com.modulecode.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class JacksonUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        // 设置时区
        mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // 日期类型格式
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 序列化所有参数，包括null
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
    }

    public static String bean2Json(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T json2Bean(String jsonStr, Class<T> objClass) throws IOException {
            return mapper.readValue(jsonStr, objClass);
    }
}