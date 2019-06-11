package com.javas.patterns.no3.abstract_factory.round2;

/**
 * Created by liyanling on 2018/11/17.
 */
public class Client {
  public static void main(String[] args){


    new PlasticBottleFactory().productCivil().show();
    new PlasticBottleFactory().productMedical().show();

    new PlasticBucketFactory().productCivil().show();
    new PlasticBucketFactory().productMedical().show();

    new PlasticCupFactory().productCivil().show();
    new PlasticCupFactory().productMedical().show();
  }
}
