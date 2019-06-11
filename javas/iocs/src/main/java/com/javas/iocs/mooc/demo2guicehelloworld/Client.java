package com.javas.iocs.mooc.demo2guicehelloworld;

import com.google.inject.Guice;

public class Client {
    public static void main(String[] args){
        Guice.createInjector(new MainModule())
                .getInstance(MyApplet.class)
                .run();
    }
}
