package com.javas.iocs.selfstudy.demo1usenew;

public class Client {

    public static void main(String[] args){
        MyService myService = new MyService();
        myService.Serve("");
        myService.Serve("123");

        /**
         * 这样做的弊端是，依赖隐藏在函数内部，模块化、可用性、扩展性、易测性都不好。
         */
    }
}
