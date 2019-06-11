package com.javas.iocs.selfstudy.demo3setter;

class MyService {

    private IValidator validator;

    public void setValidator(IValidator validator) {
        System.out.println("设值注入");
        this.validator = validator;
    }

    void Serve(String param){
        System.out.println(this.getClass().getSimpleName() + " param = " + param);
        validator.validate(param);
    }
}
