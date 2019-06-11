package com.javas.patterns.visitor.round1;

import java.util.List;

/**
 * Created by liyanling on 2018/11/3.
 */
public class PersonFemale {

  private String industry;
  private int age;
  private List<String> interests;

  public String getIndustry() {
    return industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public List<String> getInterests() {
    return interests;
  }

  public void setInterests(List<String> interests) {
    this.interests = interests;
  }

  @Override
  public String toString() {
    return "PersonFemale{" + "industry='" + industry + '\'' + ", age=" + age + ", interests=" + interests + '}';
  }
}
