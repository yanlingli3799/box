package com.javas.patterns.no4.builder.round2;

public class Client {

  public static void main(String[] args){
    UserInfo userInfo = new UserInfoBuilder()
        .name("张三")
        .age(23)
        .gender("男")
        .build();
    System.out.println(userInfo);
  }

}
