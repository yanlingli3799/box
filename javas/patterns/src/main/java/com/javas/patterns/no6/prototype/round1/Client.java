package com.javas.patterns.no6.prototype.round1;

public class Client {

  public static void main(String[] args){
    Resume resume1 = new Resume();
    Resume resume2 = resume1.clone();

    System.out.println(resume1.hashCode());
    System.out.println(resume2.hashCode());

  }

}
