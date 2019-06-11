package com.javas.patterns.no13.proxy.round1;

public class GoodsFactory implements Seller {

  private String name;

  public GoodsFactory(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public void sellGoods(String to) {
    System.out.println(String.format("我是 %s，我卖货给 %s", this.name, to));
  }
}
