package com.javas.guices.no6.binding.named;

import com.javas.guices.no6.binding.named.beans.PizzaOrder;
import com.javas.guices.no6.binding.named.beans.CreditCard;
import com.javas.guices.no6.binding.named.beans.Receipt;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {
    private final PizzaOrder pizzaOrder = new PizzaOrder(4);
    private final CreditCard creditCard = new CreditCard("123", "李颜翎");


    @org.junit.Test
    public void test(){

        Injector injector = Guice.createInjector(new BillingModule());
        BillingService billingService = injector.getInstance(BillingService.class);

        Receipt receipt = billingService.chargeOrder(pizzaOrder, creditCard);
        System.out.println("账单："+receipt);
    }
}
