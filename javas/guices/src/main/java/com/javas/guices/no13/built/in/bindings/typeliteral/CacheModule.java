package com.javas.guices.no13.built.in.bindings.typeliteral;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class CacheModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(new TypeLiteral<Storage<String,String>>(){}).to(InMemoryStorage.class);
    }
}
