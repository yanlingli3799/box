package com.javas.patterns.no4.builder.round2;

public class UserInfoBuilder implements Builder{
  private UserInfo userInfo;

  public UserInfoBuilder() {
    userInfo = new UserInfo();
  }

  public UserInfoBuilder name(String name){
    userInfo.setName(name);
    return this;
  }

  public UserInfoBuilder age(int age){
    userInfo.setAge(age);
    return this;
  }

  public UserInfoBuilder gender(String gender){
    userInfo.setGender(gender);
    return this;

  }

  @Override
  public UserInfo build() {
    return userInfo;
  }


}
