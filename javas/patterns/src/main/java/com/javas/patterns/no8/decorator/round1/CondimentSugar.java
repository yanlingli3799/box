package com.javas.patterns.no8.decorator.round1;

/**
 * Created by liyanling on 2018/11/24.
 */
public class CondimentSugar extends Condiment{

  public CondimentSugar() {
    this.desc = "糖";
    this.price = 3;
  }

  @Override
  public long cost() {
    return price;
  }
}
