package com.droiddevil.f1normalize.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

    public static final <T> T getFromJSON(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static final <T> String toJSON(T clazz) {
        return gson.toJson(clazz);
    }
}