package com.javas.iocs.mooc.demo1helloworld;

import java.util.Date;

public class Configuration {
    public static MyApplet getMainApplet(){
        return new StringWritingApplet(
                new PrintStreamWriter(System.out),
                new StringProvider() {
                    @Override
                    public String get() {
                        return "Hello World";
                    }
                }
        );
    }

}
