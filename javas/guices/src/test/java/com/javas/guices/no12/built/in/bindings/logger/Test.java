package com.javas.guices.no12.built.in.bindings.logger;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {

    @org.junit.Test
    public void test(){
        Injector injector= Guice.createInjector(new LoggerModule());

        ConsoleTransactionLog consoleTransactionLog = injector.getInstance(ConsoleTransactionLog.class);
        consoleTransactionLog.log("111");

    }
}
