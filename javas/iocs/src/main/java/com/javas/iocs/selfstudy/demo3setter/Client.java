package com.javas.iocs.selfstudy.demo3setter;

public class Client {
    public static void main(String[] args){
        NotnullValidator notnullValidator = new NotnullValidator();
        MyService myService = new MyService();
        myService.setValidator(notnullValidator);
        myService.Serve("");
        myService.Serve("123");

        /**
         * 通过成员变量的setter方法注入依赖，叫做"设值注入"
         */
    }
}
