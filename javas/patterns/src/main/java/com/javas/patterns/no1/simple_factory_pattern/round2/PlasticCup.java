package com.javas.patterns.no1.simple_factory_pattern.round2;

/**
 * Created by liyanling on 2018/11/15.
 */
public class PlasticCup implements Plastic {
  public final static String name = "塑料杯";
  public PlasticCup() {
  }

  @Override
  public void show() {
    System.out.println("我是"+name);
  }
}
