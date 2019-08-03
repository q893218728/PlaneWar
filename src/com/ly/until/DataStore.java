package com.ly.until;

import java.util.HashMap;
import java.util.Map;

public class DataStore {
    public static final Map<String,Object> map = new HashMap<>();
    public static void put(String key, Object value){
        map.put(key,value);
    }
    public static <T> T get(String key){
        return (T)map.get(key);
    }

}
