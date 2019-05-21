package com.javas.guices.no14.constructor.inject;

public class MyService  {

//    @Inject(optional = true)
    private Validator validator;

//    @Inject
//    public void setValidator(Validator validator) {
//        this.validator = validator;
//    }

    public void Serve2(){
        System.out.println(this.getClass().getSimpleName() + "接口...不校验");
    }

    public void Serve1() {
        System.out.println(this.getClass().getSimpleName() + "接口...校验");
        validator.validate();
    }
}
