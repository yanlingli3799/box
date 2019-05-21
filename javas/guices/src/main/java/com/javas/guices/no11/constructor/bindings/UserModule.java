package com.javas.guices.no11.constructor.bindings;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class UserModule extends AbstractModule{
    @Override
    protected void configure() {

        bind(String.class)
                .annotatedWith(Names.named("user"))
                .toInstance("liyanling1111");

        try{
            bind(User.class).toConstructor(User.class.getConstructor(String.class));
        }catch (NoSuchMethodException e){
            System.out.println(e);
       }

    }
}
