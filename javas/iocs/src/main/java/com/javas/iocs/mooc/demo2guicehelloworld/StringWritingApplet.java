package com.javas.iocs.mooc.demo2guicehelloworld;


import com.google.inject.Provider;

import javax.inject.Inject;

public class StringWritingApplet implements MyApplet {
    private MyWriter destination;
    private Provider<String> stringProvider;

    @Inject
    public StringWritingApplet(MyWriter destination, @HelloWorld Provider<String> stringProvider) {
        super();
        this.destination = destination;
        this.stringProvider = stringProvider;
    }

    private void printHelloWorld(){
        destination.write(stringProvider.get());
    }

    @Override
    public void run() {
        printHelloWorld();
    }
}
