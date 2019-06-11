package com.javas.patterns.no3.abstract_factory.round2;

/**
 * Created by liyanling on 2018/11/17.
 */
public class PlasticCupFactory extends AbstractFactory {


  @Override
  public PlasticCivil productCivil() {
    return new PlasticCivilCup();
  }

  @Override
  public PlasticMedical productMedical() {
    return new PlasticMedicalCup();
  }
}
