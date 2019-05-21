package com.javas.guices.no14.constructor.inject;


import com.google.inject.Binder;
import com.google.inject.Module;

public class MyModule implements Module {

    @Override
    public void configure(Binder binder) {
//        binder.bind(Validator.class);
    }
}
