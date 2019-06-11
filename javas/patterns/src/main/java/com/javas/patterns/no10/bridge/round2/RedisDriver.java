package com.javas.patterns.no10.bridge.round2;

public class RedisDriver implements Driver {

  @Override
  public void connect() {
    System.out.println("连接redis");
  }
}
