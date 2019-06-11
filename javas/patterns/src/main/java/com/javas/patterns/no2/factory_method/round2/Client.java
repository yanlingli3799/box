package com.javas.patterns.no2.factory_method.round2;


/**
 * Created by liyanling on 2018/11/17.
 */
public class Client {

  public static void main(String[] args) throws Exception{


    new PlasticBottleFactory().manufacture().show();

    new PlasticBucketFactory().manufacture().show();

    new PlasticCupFactory().manufacture().show();

  }

}
