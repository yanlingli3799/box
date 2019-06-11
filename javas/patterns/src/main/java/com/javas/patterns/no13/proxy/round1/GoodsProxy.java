package com.javas.patterns.no13.proxy.round1;

import java.util.ArrayList;
import java.util.List;

public class GoodsProxy implements Seller {

  private String name;
  private List<Seller> buyFrom;

  public GoodsProxy(String name) {
    this.name = name;
    this.buyFrom = new ArrayList<>();
    this.buyFrom.add(new GoodsFactory("义乌工厂"));
    this.buyFrom.add(new GoodsFactory("广东工厂"));
  }

  public String getName() {
    return name;
  }

  @Override
  public void sellGoods(String to) {
    for (Seller from : buyFrom) {
      from.sellGoods(this.name);
    }
    System.out.println(String.format("我是 %s，我卖货给 %s", this.name, to));
  }

}
