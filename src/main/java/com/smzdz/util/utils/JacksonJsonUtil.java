package com.smzdz.util.utils;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by hujunfei Date: 15-1-4 Time: 下午6:00
 */
public class JacksonJsonUtil {
    static volatile ObjectMapper objectMapper = new ObjectMapper();

    private JacksonJsonUtil() {
    }

    public static ObjectMapper getMapper() {
        if (objectMapper == null) {
            synchronized (JacksonJsonUtil.class) {
                if (objectMapper == null) {
                    objectMapper = new ObjectMapper();
                }
            }
        }
        return objectMapper;
    }

}
