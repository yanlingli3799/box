package com.javas.guices.no13.built.in.bindings.typeliteral;

public interface Storage<K,V> {

    V put(K key, V value);

    V get(K key);

    boolean isExists(K key);
}
