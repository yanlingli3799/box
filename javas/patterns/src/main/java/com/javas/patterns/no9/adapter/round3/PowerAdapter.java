package com.javas.patterns.no9.adapter.round3;


// 这里抽象类不对方法做实现，由子类去实现需要的方法
public abstract class PowerAdapter implements DCOutput {
  protected AC220 ac220;

  public PowerAdapter(AC220 ac220) {
    this.ac220 = ac220;
  }

  @Override
  public int output5V() {
    throw new IllegalArgumentException("unsupport output5V");
  }

  @Override
  public int output9V() {
    throw new IllegalArgumentException("unsupport output9V");
  }

  @Override
  public int output12V() {
    throw new IllegalArgumentException("unsupport output12V");
  }

  @Override
  public int output24V() {
    throw new IllegalArgumentException("unsupport output24V");
  }
}
