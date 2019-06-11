package com.javas.patterns.no10.bridge.round1;

public class RedisDriver implements Driver{

  @Override
  public void connect() {
    System.out.println("连接redis");
  }
}
