package com.javas.patterns.no8.decorator.round1;

import java.util.ArrayList;

/**
 * Created by liyanling on 2018/11/24.
 */
public class CoffeeLatte extends Coffee{

  public CoffeeLatte() {
    this.desc = "拿铁";
    this.price = 12;
    this.condimentList = new ArrayList<>();
  }

  @Override
  public long cost() {
    long cost = this.price;
    if(!condimentList.isEmpty()){
      for (Condiment c : condimentList) {
        cost += c.cost();
      }
    }
    return cost;
  }

  @Override
  public void addCondiment(Condiment condiment) {
    this.condimentList.add(condiment);
  }
}
