package com.javas.jdks.socket.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V3SayHiParam {

  private static Logger logger = LoggerFactory.getLogger(V3SayHiParam.class);

  public String name;
  public Gender gender;
  public int    weight;

  public enum Gender {
    GIRL, BOY
  }

  public V3SayHiParam() {
  }

  public V3SayHiParam(String name, Gender gender, int weight) {
    this.name = name;
    this.gender = gender;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "V3SayHiParam{" + "name='" + name + '\'' + ", gender=" + gender + ", weight=" + weight + '}';
  }


  // String -> V3SayHiParam
  public static V3SayHiParam decode(String params) {
    int separatorLocate1 = params.indexOf(',');
    int separatorLocate2 = params.indexOf(',', separatorLocate1 + 1);
    int length = params.length();

    String name = params.substring(0, separatorLocate1);
    String gender = params.substring(separatorLocate1 + 1, separatorLocate2);
    int weight = Integer.valueOf(params.substring(separatorLocate2 + 1, length));

    return new V3SayHiParam(name, Gender.valueOf(gender), weight);
  }


  // V3SayHiParam -> String
  public static String encode(V3SayHiParam v3SayHiParam) {
    return v3SayHiParam.getName() + "," + v3SayHiParam.getGender() + "," + v3SayHiParam.getWeight();
  }


}
