package com.javas.jdks.reflection;

import com.sun.xml.internal.ws.developer.Serialization;

@Serialization
public class Person {

  public  String name;
  private int    age;

  public Person() {
  }

  public Person(String name) {
    this.name = name;
  }

  private Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String sayHello() {
    return "Hi,This is " + this.name;
  }

  public String sayHello(int times) {
    return "Hi,This is " + this.name + " " + times;
  }

  private String sayBye() {
    return "Bye,This is " + this.name;
  }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
  }
}
