package com.javas.iocs.mooc.demo1helloworld;


public class StringWritingApplet implements MyApplet{
    private MyWriter destination;
    private StringProvider stringProvider;

    public StringWritingApplet(MyWriter destination, StringProvider stringProvider) {
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
