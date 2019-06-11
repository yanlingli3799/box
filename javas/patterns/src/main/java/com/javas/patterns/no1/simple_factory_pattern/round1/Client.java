package com.javas.patterns.no1.simple_factory_pattern.round1;

/**
 * Created by liyanling on 2018/11/15.
 */
public class Client {

  public static void main(String[] args){

    Plastic bottle = new PlasticBottle();
    bottle.show();

    Plastic bucket = new PlasticBucket();
    bucket.show();

    Plastic cup = new PlasticCup();
    cup.show();

  }
}
