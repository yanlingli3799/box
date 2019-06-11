package com.javas.patterns.no8.decorator.round2;

public class CondimentSugar extends Condiment{


  @Override
  public long cost() {
    return coffee.cost() + this.price;
  }

  @Override
  protected void setCoffee(Coffee coffee) {
    this.coffee = coffee;
    this.price = 3;
    this.desc = "糖";
  }
}
