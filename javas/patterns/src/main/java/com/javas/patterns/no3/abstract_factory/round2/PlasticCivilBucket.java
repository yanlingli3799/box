package com.javas.patterns.no3.abstract_factory.round2;

/**
 * Created by liyanling on 2018/11/17.
 */
public class PlasticCivilBucket extends PlasticCivil {
  public final static String name = "民用塑料桶";

  @Override
  public void show() {
    System.out.println("我是"+name);
  }
}
