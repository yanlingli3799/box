package com.javas.iocs.mooc.demo2guicehelloworld;

import com.google.inject.AbstractModule;

import java.io.PrintStream;

public class HelloWorldModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyWriter.class).to(PrintStreamWriter.class);
        bind(PrintStream.class).toInstance(System.out);
        bind(String.class).annotatedWith(HelloWorld.class).toInstance("Hello World");

    }
}
