package com.javas.guices.no16.aop.example;

import com.javas.guices.no16.aop.example.beans.CreditCard;
import com.javas.guices.no16.aop.example.beans.PizzaOrder;
import com.javas.guices.no16.aop.example.beans.Receipt;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {
    private final PizzaOrder pizzaOrder = new PizzaOrder(4);
    private final CreditCard creditCard = new CreditCard("123", "李颜翎");


    @org.junit.Test
    public void test(){
        Injector injector = Guice.createInjector(new BillingModule(),new NotOnWeekendsModule());
        BillingService billingService = injector.getInstance(BillingService.class);

        Receipt receipt = billingService.chargeOrder(pizzaOrder, creditCard);
        System.out.println("账单："+receipt);
    }
}
