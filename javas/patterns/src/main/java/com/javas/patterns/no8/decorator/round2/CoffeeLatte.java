package com.javas.patterns.no8.decorator.round2;


/**
 * Created by liyanling on 2018/11/24.
 */
public class CoffeeLatte extends Coffee {

  public CoffeeLatte() {
    this.desc = "拿铁";
    this.price = 12;
  }

  @Override
  public long cost() {
    return this.price;
  }

}
