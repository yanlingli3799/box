package com.javas.patterns.no8.decorator.round1;

import java.util.ArrayList;

/**
 * Created by liyanling on 2018/11/24.
 */
public class CoffeeAmericano extends Coffee{

  public CoffeeAmericano() {
    this.desc = "美式";
    this.price = 14;
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
