package com.javas.patterns.no9.adapter.round2;

public class PowerAdapter implements DC5 {
  private AC220 ac220;

  public PowerAdapter(AC220 ac220) {
    this.ac220 = ac220;
  }

  @Override
  public int output5V() {
    return ac220.output220V()/44;
  }
}
