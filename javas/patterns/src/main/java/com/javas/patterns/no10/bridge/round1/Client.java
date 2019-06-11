package com.javas.patterns.no10.bridge.round1;

public class Client {

  public static void main(String[] args){
    new MongooseDriver().connect();
    new RedisDriver().connect();
  }

}
