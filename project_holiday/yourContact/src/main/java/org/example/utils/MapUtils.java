package org.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class MapUtils {

    private static final Gson gson =
            new GsonBuilder().setPrettyPrinting().create();

    public static String mapToJson(Map<String, Object> map) {
        return gson.toJson(map);
    }

    public static Map<String, Object> jsonToMap(String json) {
        return gson.fromJson(json, Map.class);
    }

    public static String getString(Map<String, Object> map, String key) {
        return (String) map.get(key);
    }

    public static int getInt(Map<String, Object> map, String key) {
        Double value = (Double) map.get(key);
        return value.intValue();
    }

    public static boolean hasKey(Map<String, Object> map, String key) {
        return map.containsKey(key);
    }
}
