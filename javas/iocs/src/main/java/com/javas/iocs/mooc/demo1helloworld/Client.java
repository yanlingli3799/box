package com.javas.iocs.mooc.demo1helloworld;

public class Client {
    public static void main(String[] args){
        MyApplet myApplet = Configuration.getMainApplet();
        myApplet.run();
    }
}
