package com.javas.jdks.serialization.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {

    public static void main(String[] args) throws Exception {
        toFile();
        fromFile();
    }


    // Object -> 文件
    public static void toFile() throws Exception {
        User user = new User();
        user.setUserId(1223);
        user.setUserName("令习习习");
        user.setAddress("北京");

        System.out.println("对象："+user.toString());
        System.out.println("对象中的静态变量："+user.getHH());
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("./out.txt")));
        oo.writeObject(user);
        System.out.println("序列化成功");
        oo.close();
    }

    // 文件 -> Object
    public static void fromFile() throws Exception{
        User tmp = new User();
        tmp.setHH("我是静态变量，我的值是存在JVM静态存储区的，不是反序列化来的");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("./out.txt")));
        System.out.println("反序列化成功");
        User user = (User) ois.readObject();
        System.out.println("对象："+user.toString());
        System.out.println("对象中的静态变量："+user.getHH());
        ois.close();
    }
}
