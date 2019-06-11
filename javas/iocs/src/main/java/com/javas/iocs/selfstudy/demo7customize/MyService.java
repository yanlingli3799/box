package com.javas.iocs.selfstudy.demo7customize;


import com.google.inject.Inject;

class MyService  {

    @Inject
    private IValidator validator;

    void Serve1(){
        System.out.println(this.getClass().getSimpleName());
    }

    void Serve2(String param){
        System.out.println(this.getClass().getSimpleName() + " param = " + param);
        validator.validate(param);
    }


}
