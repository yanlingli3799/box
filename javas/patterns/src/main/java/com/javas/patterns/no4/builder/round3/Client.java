package com.javas.patterns.no4.builder.round3;


public class Client {

  public static void main(String[] args){
    UserInfo userInfo = new UserInfo()
        .setName("张三")
        .setAge(23)
        .setGender("男");
    System.out.println(userInfo);
  }

}
