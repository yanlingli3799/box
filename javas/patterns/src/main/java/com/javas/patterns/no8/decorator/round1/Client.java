package com.javas.patterns.no8.decorator.round1;

public class Client {

  public static void main(String[] args) {
    Coffee coffeeAmericano = new CoffeeAmericano();

    coffeeAmericano.addCondiment(new CondimentSugar());
    coffeeAmericano.addCondiment(new CondimentMilk());

    System.out.println(coffeeAmericano.cost());

  }

}
