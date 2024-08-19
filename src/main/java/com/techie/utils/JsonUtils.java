package com.techie.utils;

import com.fasterxml.jackson.databind.*;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String asJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}