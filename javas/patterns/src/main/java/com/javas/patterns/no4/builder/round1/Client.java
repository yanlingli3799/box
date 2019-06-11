package com.javas.patterns.no4.builder.round1;


/**
 * Created by liyanling on 2018/11/18.
 */
public class Client {

  public static void main(String[] args){
    UserInfo userInfo1 = new UserInfo();
    userInfo1.setName("张三");
    userInfo1.setAge(23);
    userInfo1.setGender("男");
    System.out.println(userInfo1);

    // 或者
    UserInfo userInfo2 = new UserInfo("李四",25,"男");
    System.out.println(userInfo2);


  }
}
