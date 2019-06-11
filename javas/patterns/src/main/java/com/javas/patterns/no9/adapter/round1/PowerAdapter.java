package com.javas.patterns.no9.adapter.round1;

public class PowerAdapter extends AC220 implements DC5{

  @Override
  public int output5V() {
    return output220V()/44;
  }
}
