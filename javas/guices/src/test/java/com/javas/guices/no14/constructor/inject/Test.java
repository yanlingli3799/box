package com.javas.guices.no14.constructor.inject;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {

    @org.junit.Test
    public void test(){

        // 根据注射规则，生成注射者
        Injector injector= Guice.createInjector(new MyModule());

        // 获取一个 MyService 实例
        MyService myService= injector.getInstance(MyService.class);
        myService.Serve2();
//        myService.Serve1();//todo：报空指针异常

    }
}
