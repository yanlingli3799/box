package com.javas.jdks.strings;

import java.lang.reflect.Field;

public class StringCompare {
    public static void main(String[] args) throws Exception {
//        demo1();
//        demo4();
//        demo3();
//        demo4();
//        demo5();
//        demo6();
//        demo7();
//        demo8();
        demo9();
//        demo10();
    }

    private static void demo1(){
        // 1个字面值创建，1个 new 创建
        System.out.println("demo1-----------------");
        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println(s1 == s2); // 结果：false，指向不同的内存地址
        System.out.println(s1.equals(s2));// 结果：true
    }


    private static void demo2(){
        // 1个 new 创建，1个字面值创建
        System.out.println("demo4-----------------");
        String s1 = new String("hello");
        String s2 = "hello";
        System.out.println(s1 == s2); // 结果：false，指向不同的内存地址
        System.out.println(s1.equals(s2));// 结果：true
    }

    private static void demo3(){
        // 2个都是 new 创建
        System.out.println("demo3-----------------");
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2); // 结果：false，指向不同的内存地址
        System.out.println(s1.equals(s2));// 结果：true
    }

    private static void demo4(){
        // 2个都是字面值创建
        System.out.println("demo4-----------------");
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2); // 结果：true，指向同一内存地址
        System.out.println(s1.equals(s2));// 结果：true
    }

    private static void demo5(){
        // 2个都是字面值创建，对其中一个赋新值，再改回来
        System.out.println("demo5-----------------");

        String s1="hello";
        String s2="hello";

        System.out.println(s1==s2);// 结果：true

        s2= "World?";
        System.out.println(s1==s2);// 结果：false，s2指向了一个新的字符常量所在内存地址

        s2="hello";
        System.out.println(s1==s2);// 结果：true，又重新指回去了
    }

    private static void demo6(){
        // 2个都是 new 创建，将其中一个 赋值给 另一个
        System.out.println("demo6-----------------");
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2); // 结果：false
        s1 = s2;
        System.out.println(s1 == s2); // 结果：true，s1 = s2使得 s1 指向了 s2 所指的内存地址
        System.out.println(s1.equals(s2));// 结果：true
    }


    private static void demo7(){
        // replace操作
        System.out.println("demo7-----------------");
        String s1 = "hello";
        System.out.println(s1); //结果：hello
        System.out.println(s1.replace('h','H'));//结果：Hello
        System.out.println(s1);//结果：hello

        String s2 = new String("hello");
        System.out.println(s2); //结果：hello
        System.out.println(s2.replace('h','H'));//结果：Hello
        System.out.println(s2);//结果：hello
    }


    private static void demo8() throws Exception{
        // 反射修改 String 中的 value
        System.out.println("demo8-----------------");

        String s = "hello";
        System.out.println("s = "+s); //结果：hello

        //获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");

        //改变value字段的访问权限
        valueFieldOfString.setAccessible(true);

        //获取s对象上的value属性的值
        char[] value = (char[]) valueFieldOfString.get(s);

        //改变value所引用的数组中的第0个字符
        value[0] = 'H';

        System.out.println("s = "+s); //结果：Hello
    }



    private static void demo9() throws Exception {
        // 2个都是字面值创建，比较 String 引用，和 value 引用；修改其中一个的 value值。
        System.out.println("demo9-----------------");
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "Hello";
        System.out.println(s1.equals(s3));

//        System.out.println(s1 == s2);// 结果：true

        //获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");

        //改变value字段的访问权限
        valueFieldOfString.setAccessible(true);

        //获取s对象上的value属性的值
        char[] value_s1 = (char[]) valueFieldOfString.get(s1);
        char[] value_s2 = (char[]) valueFieldOfString.get(s2);

//        System.out.println(value_s1 == value_s2);//结果：true，s1 和 s2 的引用也是相同的

        value_s1[0]='H';
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s1 == s2);// 结果：true

//        System.out.println(s1=="hello");
        System.out.println("s1="+s1);
        System.out.println(s1.equals(s3));
    }


    private static void demo10() throws Exception {
        System.out.println("demo10-----------------");
        String s= "你好";

        //获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");

        //改变value字段的访问权限
        valueFieldOfString.setAccessible(true);

        //获取s对象上的value属性的值
        char[] value = (char[]) valueFieldOfString.get(s);
        for (char c:value
             ) {
            System.out.println(c+"   "+Integer.toHexString(c));
        }
    }



}
