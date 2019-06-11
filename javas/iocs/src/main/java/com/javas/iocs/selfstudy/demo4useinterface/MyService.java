package com.javas.iocs.selfstudy.demo4useinterface;

class MyService implements MyInject {

    private IValidator validator;

    void Serve(String param){
        System.out.println(this.getClass().getSimpleName() + " param = " + param);
        validator.validate(param);
    }

    @Override
    public void inject(IValidator validator) {
        System.out.println("接口注入");
        this.validator = validator;
    }
}
