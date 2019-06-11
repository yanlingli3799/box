package com.javas.iocs.selfstudy.demo1usenew;

class MyService {

    void Serve(String param){
        System.out.println(this.getClass().getSimpleName() + " param = " + param);
        NotnullValidator notnullValidator = new NotnullValidator();
        notnullValidator.validate(param);
    }
}
