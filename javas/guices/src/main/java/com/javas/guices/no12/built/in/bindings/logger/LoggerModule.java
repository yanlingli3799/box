package com.javas.guices.no12.built.in.bindings.logger;

import com.google.inject.AbstractModule;

public class LoggerModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(ConsoleTransactionLog.class);
    }
}
