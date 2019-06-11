package com.javas.iocs.mooc.demo2guicehelloworld;

import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule{
    @Override
    protected void configure() {
        install(new HelloWorldModule());
    }
}
