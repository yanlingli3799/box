package com.javas.patterns.no10.bridge.round2;

public class MongooseDriver implements Driver {

  @Override
  public void connect() {
    System.out.println("连接mongoose");
  }
}
