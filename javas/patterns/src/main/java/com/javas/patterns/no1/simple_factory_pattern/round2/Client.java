package com.javas.patterns.no1.simple_factory_pattern.round2;

/**
 * Created by liyanling on 2018/11/15.
 */
public class Client {

  public static void main(String[] args) throws Exception{


    PlasticFactory.manufacture("塑料瓶").show();

    PlasticFactory.manufacture("塑料桶").show();

    PlasticFactory.manufacture("塑料杯").show();

  }
}
