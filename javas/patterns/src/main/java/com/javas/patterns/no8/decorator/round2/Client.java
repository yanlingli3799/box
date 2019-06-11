package com.javas.patterns.no8.decorator.round2;

public class Client {

  public static void main(String[] args){
    CoffeeLatte coffeeLatte = new CoffeeLatte();

    CondimentMilk milk = new CondimentMilk();
    milk.setCoffee(coffeeLatte);

    CondimentSugar sugar = new CondimentSugar();
    sugar.setCoffee(milk);

    System.out.println(sugar.cost());


  }

}
