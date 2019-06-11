package com.javas.patterns.no8.decorator.round2;

/**
 * Created by liyanling on 2018/11/24.
 */
public class CoffeeAmericano extends Coffee {

  public CoffeeAmericano() {
    this.desc = "美式";
    this.price = 14;
  }

  @Override
  public long cost() {
    return this.price;
  }

}
