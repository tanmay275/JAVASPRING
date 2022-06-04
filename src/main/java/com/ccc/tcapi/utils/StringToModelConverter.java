package com.ccc.tcapi.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StringToModelConverter {

    public static Object ConvertJsonStringToCustomObject(String jsonString, Class<?> classType) {
        Object customObject = null;

        try {
            customObject = new ObjectMapper().readValue(jsonString, classType);
        } catch (Exception e) {
        }

        return customObject;
    }

    public static String convertCustomObjectToJsonString(Object object) {
        String jsonString = null;
        try {
            jsonString = new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
        }
        return jsonString;
    }
}
