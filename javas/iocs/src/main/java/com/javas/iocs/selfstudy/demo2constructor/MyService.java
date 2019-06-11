package com.javas.iocs.selfstudy.demo2constructor;

class MyService {

    private IValidator validator;

    MyService(IValidator validator) {
        System.out.println("构造子注入");
        this.validator = validator;
    }

    void Serve(String param){
        System.out.println(this.getClass().getSimpleName() + " param = " + param);
        validator.validate(param);
    }
}
