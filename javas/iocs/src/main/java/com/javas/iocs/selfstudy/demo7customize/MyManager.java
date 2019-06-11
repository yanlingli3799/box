package com.javas.iocs.selfstudy.demo7customize;

public class MyManager {

    <T> T getInstance(Class<T> type) throws IllegalAccessException, InstantiationException {
        return type.newInstance();
    }
}
