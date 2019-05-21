package com.javas.guices.no5.binding.annotations;

import com.javas.guices.no5.binding.annotations.beans.CreditCard;
import com.javas.guices.no5.binding.annotations.beans.PizzaOrder;
import com.javas.guices.no5.binding.annotations.beans.Receipt;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Test {

    private final PizzaOrder pizzaOrder = new PizzaOrder(4);
    private final CreditCard creditCard = new CreditCard("123","李颜翎");


    /**
     * 默认 paypal + db， 测试
     */
    @org.junit.Test
    public void test1(){
        Injector injector = Guice.createInjector(new BillingModule());
        BillingService billingService = injector.getInstance(BillingService.class);

        Receipt receipt = billingService.chargeOrder(pizzaOrder,creditCard);
        System.out.println("账单："+receipt);
    }

    /**
     * 指定 paypal + db， 测试
     */
    @org.junit.Test
    public void test2(){
        Injector injector = Guice.createInjector(new BillingModule());
        BillingService billingService = injector.getInstance(PaypalRealBillingService.class);
        Receipt receipt = billingService.chargeOrder(pizzaOrder,creditCard);
        System.out.println("账单："+receipt);
    }

    /**
     * paypal + memory ，测试
     * 这儿有个问题，@PayPal 注解绑定到 fake，有点奇怪，倒也不是不能接受
     */
    @org.junit.Test
    public void test3(){
        Injector injector = Guice.createInjector(new TestBillingModule());
        BillingService billingService = injector.getInstance(BillingService.class);

        Receipt receipt = billingService.chargeOrder(pizzaOrder,creditCard);
        System.out.println("账单："+receipt);
    }

}
