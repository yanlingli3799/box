package com.javas.patterns.no4.builder.round3;

public class UserInfo {
  private String name;
  private int age;
  private String gender;

  public UserInfo() {
  }


  public String getName() {
    return name;
  }

  public UserInfo setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public UserInfo setAge(int age) {
    this.age = age;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public UserInfo setGender(String gender) {
    this.gender = gender;
    return this;
  }

  @Override
  public String toString() {
    return "UserInfo{" + "name='" + name + '\'' + ", age=" + age + ", gender='" + gender + '\'' + '}';
  }
}
