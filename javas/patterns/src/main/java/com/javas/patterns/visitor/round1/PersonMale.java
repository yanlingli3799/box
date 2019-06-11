package com.javas.patterns.visitor.round1;

import java.util.List;

/**
 * Created by liyanling on 2018/11/3.
 */
public class PersonMale {

  private String industry;
  private int age;
  private List<String> interests;
  private boolean isSingle;

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

  public boolean isSingle() {
    return isSingle;
  }

  public void setSingle(boolean single) {
    isSingle = single;
  }

  @Override
  public String toString() {
    return "PersonMale{" + "industry='" + industry + '\'' + ", age=" + age + ", interests=" + interests + ", isSingle="
           + isSingle + '}';
  }
}
