package com.javas.patterns.no9.adapter.round1;

public class Client {

  public static void main(String[] args){
    DC5 dc5 = new PowerAdapter();
    System.out.println(dc5.output5V());
  }
}
