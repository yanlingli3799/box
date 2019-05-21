package com.javas.guices.no7.instance.binding;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class DbModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("JDBC Url")).toInstance("jdbc:mysql://localhost/pizza");
    }
}
