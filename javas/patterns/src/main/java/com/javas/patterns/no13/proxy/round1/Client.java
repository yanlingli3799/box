package com.javas.patterns.no13.proxy.round1;

public class Client {

  public static void main(String[] args) {
    new GoodsProxy("家乐福").sellGoods("小明");
  }
}
