package com.javas.iocs.selfstudy.demo6guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Client {

    public static void main(String[] args){
        // 定义依赖注入规则
        MyModule module = new MyModule();

        // 根据注入规则，生成 injector
        Injector injector = Guice.createInjector(module);

        // 获取 MyService 实例
        MyService myService = injector.getInstance(MyService.class);

        // 来两个case
        myService.Serve("");
        myService.Serve("123");
    }
}
