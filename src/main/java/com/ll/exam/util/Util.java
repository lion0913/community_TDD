package com.ll.exam.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.exam.article.dto.ArticleDto;

public class Util {
    public static class json {
        private static ObjectMapper om;

        static {
            om = new ObjectMapper();
        }
        public static String toJson(Object obj, String defaultValue) {
            try {
                return om.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

        public static Object toObj(String jsonStr, Class cls, Object defaultVal) {
            try {
                return om.readValue(jsonStr, cls);
            } catch (JsonMappingException e) {
                return defaultVal;
            } catch (JsonProcessingException e) {
                return defaultVal;
            }
        }
    }
}
