package com.javas.guices.no4.linked.bindings;

import com.javas.guices.no4.linked.bindings.beans.CreditCard;
import com.javas.guices.no4.linked.bindings.beans.PizzaOrder;
import com.javas.guices.no4.linked.bindings.beans.Receipt;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {

    private final PizzaOrder pizzaOrder = new PizzaOrder(4);
    private final CreditCard creditCard = new CreditCard("123","李颜翎");


    /**
     * paypal + db， 测试
     */
    @org.junit.Test
    public void test1(){
        Injector injector = Guice.createInjector(new BillingModule());
        BillingService billingService = injector.getInstance(BillingService.class);

        Receipt receipt = billingService.chargeOrder(pizzaOrder, creditCard);
        System.out.println("账单："+receipt);
    }

    /**
     * fake + memory ，测试
     */
    @org.junit.Test
    public void test2(){
        Injector injector = Guice.createInjector(new TestBillingModule());
        BillingService billingService = injector.getInstance(BillingService.class);

        Receipt receipt = billingService.chargeOrder(pizzaOrder,creditCard);
        System.out.println("账单："+receipt);
    }


}
