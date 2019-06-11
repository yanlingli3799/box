package com.javas.iocs.selfstudy.demo5usespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    /**
     * 构造子注入 和 设值注入，唯一的区别就是标签中定义依赖的元素不同。
     * 构造子注入使用：constructor-arg，设值注入使用：property。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("case1：测试spring容器构造子注入（基于XML配置）...");
        demo1();
        System.out.println("..................................................");

        System.out.println("case2：测试spring容器设值注入（基于XML配置）...");
        demo2();
        System.out.println("..................................................");

        System.out.println("case3：测试spring容器自动装载byName（基于XML配置）...");
        demo3();
        System.out.println("..................................................");

        System.out.println("case4：测试spring容器自动装载byType（基于XML配置）...");
        demo4();
        System.out.println("..................................................");

        System.out.println("case5：测试spring容器自动装载constructor（基于XML配置）...");
        demo5();
        System.out.println("..................................................");

    }

    private static void demo1(){
        // 读取配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("demo5_configioc-byxml-case1.xml");
        // 构造子注入实例
        MyService service = (MyService)context.getBean("s");
        service.Serve("");
        service.Serve("123");
    }

    private static void demo2(){
        // 读取配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("demo5_configioc-byxml-case2.xml");
        // 设值注入实例
        MyService service = (MyService)context.getBean("s");
        service.Serve("");
        service.Serve("123");
    }

    private static void demo3(){
        // 读取配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("demo5_configioc-byxml-case3.xml");
        // 自动装载，byName
        MyService service = (MyService)context.getBean("s");
        service.Serve("");
        service.Serve("123");
    }

    private static void demo4(){
        // 读取配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("demo5_configioc-byxml-case4.xml");
        // 自动装载，byType
        MyService service = (MyService)context.getBean("s");
        service.Serve("");
        service.Serve("123");
    }

    private static void demo5(){
        // 读取配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("demo5_configioc-byxml-case5.xml");
        // 自动装载，constructor
        MyService service = (MyService)context.getBean("s");
        service.Serve("");
        service.Serve("123");
    }

}
