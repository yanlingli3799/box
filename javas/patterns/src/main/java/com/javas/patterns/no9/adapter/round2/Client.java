package com.javas.patterns.no9.adapter.round2;


public class Client {

  public static void main(String[] args){
    AC220 ac220 = new AC220();
    DC5 dc5 = new PowerAdapter(ac220);
    System.out.println(dc5.output5V());
  }
}
