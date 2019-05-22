package com.javas.jdks.socket.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class V2SayHiParam {

  private static Logger logger = LoggerFactory.getLogger(V2SayHiParam.class);

  public String name;
  public Gender gender;
  public int    weight;

  public enum Gender {
    GIRL, BOY
  }

  public V2SayHiParam() {
  }

  public V2SayHiParam(String name, Gender gender, int weight) {
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
    return "V2SayHiParam{" + "name='" + name + '\'' + ", gender=" + gender + ", weight=" + weight + '}';
  }


  // String -> V2SayHiParam
  public static V2SayHiParam decode(String params) {
    int separatorLocate1 = params.indexOf(',');
    int separatorLocate2 = params.indexOf(',', separatorLocate1 + 1);
    int length = params.length();

    String name = params.substring(0, separatorLocate1);
    String gender = params.substring(separatorLocate1 + 1, separatorLocate2);
    int weight = Integer.valueOf(params.substring(separatorLocate2 + 1, length));

    return new V2SayHiParam(name, Gender.valueOf(gender), weight);
  }


  // V2SayHiParam -> String
  public static String encode(V2SayHiParam v2SayHiParam) {
    return v2SayHiParam.getName() + "," + v2SayHiParam.getGender() + "," + v2SayHiParam.getWeight();
  }


}
