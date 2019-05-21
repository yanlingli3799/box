package com.javas.guices.no11.constructor.bindings;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {

    @org.junit.Test
    public void test(){
        Injector injector = Guice.createInjector(new UserModule());
        User user = injector.getInstance(User.class);
        System.out.println("user: "+user.toString());
    }
}
