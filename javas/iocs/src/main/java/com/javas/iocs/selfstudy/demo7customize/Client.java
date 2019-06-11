package com.javas.iocs.selfstudy.demo7customize;


public class Client {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        MyManager myManager = new MyManager();

        NotnullValidator notnullValidator = myManager.getInstance(NotnullValidator.class);
        notnullValidator.validate("111");

        MyService myService = myManager.getInstance(MyService.class);
        myService.Serve1();
//        myService.Serve2("11xxx");

    }
}
