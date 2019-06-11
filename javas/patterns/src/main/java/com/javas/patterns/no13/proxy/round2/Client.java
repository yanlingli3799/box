package com.javas.patterns.no13.proxy.round2;

public class Client {

  public static void main(String[] args) {
    GoodsProxy proxy1 = new GoodsProxy("全国总代理");
    proxy1.addSub(new GoodsFactory("广州工厂"));
    proxy1.addSub(new GoodsFactory("义乌工厂"));
    proxy1.addSub(new GoodsFactory("天津工厂"));
    proxy1.sellGoods("小明");

    System.out.println("--------------");
    GoodsProxy proxy2 = new GoodsProxy("家乐福");
    proxy2.addSub(proxy1);
    proxy2.addSub(new GoodsFactory("美国工厂"));
    proxy2.sellGoods("大熊");

  }
}
