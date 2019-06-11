package com.javas.iocs.selfstudy.demo6guice;

import com.google.inject.Binder;
import com.google.inject.Module;

public class MyModule implements Module{
    @Override
    public void configure(Binder binder) {
        System.out.println("guice注入规则，绑定 IValidator 到 NotnullValidator");
        binder.bind(IValidator.class).to(NotnullValidator.class);
    }
}
