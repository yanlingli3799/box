package com.javas.guices.no10.untargetted.bindings;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class UserModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(User.class);
        bind(String.class)
                .annotatedWith(Names.named("user"))
                .toInstance("liyanling");
    }
}
