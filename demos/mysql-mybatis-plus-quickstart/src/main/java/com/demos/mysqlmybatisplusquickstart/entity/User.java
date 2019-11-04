package com.demos.mysqlmybatisplusquickstart.entity;

public class User {
  private long id;
  private String cardId;
  private String name;
  private int age;
  private String remark;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
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

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public String toString() {
    return "User{" +
           "id=" + id +
           ", cardId='" + cardId + '\'' +
           ", name='" + name + '\'' +
           ", age=" + age +
           ", remark='" + remark + '\'' +
           '}';
  }
}
