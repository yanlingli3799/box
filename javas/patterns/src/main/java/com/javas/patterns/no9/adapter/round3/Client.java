package com.javas.patterns.no9.adapter.round3;


public class Client {

  public static void main(String[] args) {
    AC220 ac220 = new AC220();
    Power5VAdapter adapter = new Power5VAdapter(ac220);
    System.out.println(adapter.output5V());
    System.out.println(adapter.output9V());
  }

}
