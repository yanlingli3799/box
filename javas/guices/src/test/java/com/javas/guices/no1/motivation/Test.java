package com.javas.guices.no1.motivation;

import com.javas.guices.no1.motivation.beans.PizzaOrder;
import com.javas.guices.no1.motivation.beans.Receipt;
import com.javas.guices.no1.motivation.beans.CreditCard;

public class Test {

    private final PizzaOrder pizzaOrder = new PizzaOrder(4);
    private final CreditCard creditCard = new CreditCard("123","李颜翎");
    /**
     * BillingService 只能使用真实paypal账户消费，结果依赖第三方，无法自由assert
     */
    @org.junit.Test
    public void test(){
        BillingService billingService = new RealBillingService();
        Receipt receipt = billingService.chargeOrder(pizzaOrder, creditCard);
        System.out.println("收据："+receipt.toString());
    }

}
