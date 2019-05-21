package com.javas.guices.no7.instance.binding;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {

    @org.junit.Test
    public void test(){

        Injector injector = Guice.createInjector(new DbModule());
        DbUtil util = injector.getInstance(DbUtil.class);
        util.print();
    }
}
