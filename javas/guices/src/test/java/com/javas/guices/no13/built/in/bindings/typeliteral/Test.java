package com.javas.guices.no13.built.in.bindings.typeliteral;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {

    @org.junit.Test
    public void test(){
        Injector injector = Guice.createInjector(new CacheModule());
        Client client = injector.getInstance(Client.class);
        client.putToStore();
        client.getFromStore();
        System.out.println("common : "+client.toString());
    }
}
