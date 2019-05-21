package com.javas.guices.no13.built.in.bindings.typeliteral;

import com.google.common.collect.Maps;

import java.util.Map;

public class InMemoryStorage implements Storage<String,String>{

    Map<String, String> cache = Maps.newConcurrentMap();

    @Override
    public String put(String key, String value) {
        return cache.put(key,value);
    }

    @Override
    public String get(String key) {
        return cache.get(key);
    }

    @Override
    public boolean isExists(String key) {
        return cache.containsKey(key);
    }
}
