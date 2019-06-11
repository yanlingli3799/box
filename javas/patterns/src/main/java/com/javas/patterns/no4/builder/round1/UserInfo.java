package com.javas.patterns.no4.builder.round1;

/**
 * Created by liyanling on 2018/11/18.
 */
public class UserInfo {
  private String name;
  private int age;
  private String gender;

  public UserInfo() {
  }

  public UserInfo(String name, int age, String gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "UserInfo{" + "name='" + name + '\'' + ", age=" + age + ", gender='" + gender + '\'' + '}';
  }
}
