package com.javas.patterns.no8.decorator.round2;

/**
 * Created by liyanling on 2018/11/24.
 */
public abstract class Condiment extends Coffee {

  protected Coffee coffee;

  protected abstract void setCoffee(Coffee coffee);

}
