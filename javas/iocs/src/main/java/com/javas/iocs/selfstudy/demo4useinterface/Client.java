package com.javas.iocs.selfstudy.demo4useinterface;

public class Client {
    public static void main(String[] args){
        NotnullValidator notnullValidator = new NotnullValidator();
        MyService myService = new MyService();
        myService.inject(notnullValidator);
        myService.Serve("");
        myService.Serve("123");

        /**
         * 通过实现一个单独的依赖注入接口，实现依赖注入，叫做"接口注入"。
         * 不常见的用法，构造函数和setter就够用了。
         *
         * 通过构造函数、setter、接口注入依赖，仍然存在问题。
         * 加入一个类A依赖非常多的其他类，每一个都要手动new，然后set，太麻烦了。
         * 怎么办呢？上框架。
         */
    }
}
