package com.javas.iocs.selfstudy;


import com.javas.iocs.selfstudy.demo1usenew.Client;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println("测试场景1：内部 new 管理依赖");
        Client.main(null);
        System.out.println("-------------------------------------------------");

        System.out.println("测试场景2：构造子注入依赖");
        com.javas.iocs.selfstudy.demo2constructor.Client.main(null);
        System.out.println("-------------------------------------------------");

        System.out.println("测试场景3：成员变量setter注入依赖");
        com.javas.iocs.selfstudy.demo3setter.Client.main(null);
        System.out.println("-------------------------------------------------");

        System.out.println("测试场景4：实现自定义 Inject 接口，通过接口的 inject() 方法注入依赖");
        com.javas.iocs.selfstudy.demo4useinterface.Client.main(null);
        System.out.println("-------------------------------------------------");

        System.out.println("测试场景5：spring 框架");
        com.javas.iocs.selfstudy.demo5usespring.Client.main(null);
        System.out.println("-------------------------------------------------");

        System.out.println("测试场景6：guice 框架");
        com.javas.iocs.selfstudy.demo6guice.Client.main(null);
        System.out.println("-------------------------------------------------");

        System.out.println("测试场景7：定制");
        com.javas.iocs.selfstudy.demo7customize.Client.main(null);
        System.out.println("-------------------------------------------------");

    }
}
