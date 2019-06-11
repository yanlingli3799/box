package com.javas.patterns.no13.proxy.round2;

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
    System.out.println(String.format("我是 %s，卖毛巾给 %s", this.name, to));
  }
}
