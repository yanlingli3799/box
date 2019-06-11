package com.javas.patterns.no2.factory_method.round2;

/**
 * Created by liyanling on 2018/11/17.
 */
public class PlasticBottleFactory implements Factory{

  @Override
  public Plastic manufacture() {
    return new PlasticBottle();
  }
}
