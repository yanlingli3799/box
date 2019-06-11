package com.javas.patterns.no8.decorator.round1;

/**
 * Created by liyanling on 2018/11/24.
 */
public class CondimentMilk extends Condiment{

  public CondimentMilk() {
    this.desc = "奶";
    this.price = 4;
  }

  @Override
  public long cost() {
    return price;
  }
}
