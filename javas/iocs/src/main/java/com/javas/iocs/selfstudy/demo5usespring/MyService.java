package com.javas.iocs.selfstudy.demo5usespring;


public class MyService {

    private IValidator validator;

    public MyService(IValidator validator) {
        this.validator = validator;
    }

    public void setValidator(IValidator validator) {
        this.validator = validator;
    }

    public MyService() {
    }

    void Serve(String param){
        System.out.println(this.getClass().getSimpleName() + " param = " + param);
        validator.validate(param);
    }

}
