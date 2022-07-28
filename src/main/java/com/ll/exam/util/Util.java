package com.ll.exam.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.exam.article.dto.ArticleDto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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


        public static <T> T toObj(String jsonStr, Class<T> typeReference, T defaultVal) {
            try {
                return (T)om.readValue(jsonStr, typeReference);
            } catch (JsonMappingException e) {
                return defaultVal;
            } catch (JsonProcessingException e) {
                return defaultVal;
            }
        }

        public static <T> T toObj(String jsonStr, TypeReference<T> typeReference, T defaultVal) {
            try {
                return (T)om.readValue(jsonStr, typeReference);
            } catch (JsonMappingException e) {
                return defaultVal;
            } catch (JsonProcessingException e) {
                return defaultVal;
            }
        }

    }

    public static Map<String, Object> mapOf(Object... args) {
        Map<String, Object> map = new LinkedHashMap<>();

        int dataSize = args.length/2;

        for(int i = 0; i < dataSize; i++) {
            int keyIndex = i*2+0;
            int valueIndex = i*2+1;

            map.put((String)args[keyIndex], args[valueIndex]);
        }

        return map;
    }
}
