package com.javas.iocs.selfstudy.demo6guice;


import com.google.inject.Inject;

class MyService  {

    @Inject
    private IValidator validator;

    void Serve(String param){
        System.out.println(this.getClass().getSimpleName() + " param = " + param);
        validator.validate(param);
    }


}
