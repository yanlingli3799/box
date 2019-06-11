package com.javas.patterns.no13.proxy.round2;

import java.util.ArrayList;
import java.util.List;

public class GoodsProxy implements Seller, Proxy {

  private String name;
  private List<Seller> buyFrom;

  public GoodsProxy(String name) {
    this.name = name;
    this.buyFrom = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  @Override
  public void sellGoods(String to) {
    for (Seller from : buyFrom) {
      from.sellGoods(this.name);
    }
    System.out.println(String.format("我是 %s，我卖毛巾给 %s", this.name, to));
  }

  @Override
  public void addSub(Seller seller) {
    this.buyFrom.add(seller);
  }
}
