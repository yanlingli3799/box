package com.javas.iocs.selfstudy.demo2constructor;

public class Client {
    public static void main(String[] args){
        NotnullValidator notnullValidator = new NotnullValidator();
        MyService myService = new MyService(notnullValidator);
        myService.Serve("");
        myService.Serve("123");

        /**
         * 依赖由外部管理，可测性变强了。
         * 这其实就是一种依赖注入方法。
         * 通过构造方法注入依赖，叫做"构造子注入"。
         */
    }
}
