package com.javas.iocs.selfstudy.demo4useinterface;

class NotnullValidator implements IValidator{

    @Override
    public void validate(String param){
        System.out.println(this.getClass().getSimpleName()+ " validating param {"+param+"}");
        if(null == param || 0 == param.length()){
            System.out.println(this.getClass().getSimpleName() + " param can not be null or empty");
        }
    }
}
