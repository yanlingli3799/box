package com.javas.jdks.serialization;


public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("demo1：对象-文件，简单序列化");
        com.javas.jdks.serialization.demo1.Client.main(null);
        System.out.println("-----------------------------------------------");

        System.out.println("demo2：对象-文件，隐藏 address 信息");
        com.javas.jdks.serialization.demo2.Client.main(null);
        System.out.println("-----------------------------------------------");

        System.out.println("demo4：对象-文件，实现 Externalizable 接口");
        com.javas.jdks.serialization.demo4.Client.main(null);
        System.out.println("-----------------------------------------------");

    }

}
