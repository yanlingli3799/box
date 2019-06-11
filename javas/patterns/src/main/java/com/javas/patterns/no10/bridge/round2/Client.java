package com.javas.patterns.no10.bridge.round2;

public class Client {

  public static void main(String[] args){
    BridgeImpl bridge= new BridgeImpl();
    bridge.setDriver(new MongooseDriver());
    bridge.connect();

    bridge.setDriver(new RedisDriver());
    bridge.connect();
  }

}
