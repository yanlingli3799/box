package com.javas.guices.no3.motivation;

import com.javas.guices.no3.motivation.beans.CreditCard;
import com.javas.guices.no3.motivation.beans.PizzaOrder;
import com.javas.guices.no3.motivation.beans.Receipt;
import com.javas.guices.no3.motivation.logger.DatabaseTransactionLog;
import com.javas.guices.no3.motivation.processor.PaypalCreditCardProcessor;

import junit.framework.TestCase;

public class Test extends TestCase{

    private final PizzaOrder pizzaOrder = new PizzaOrder(4);
    private final CreditCard creditCard = new CreditCard("123","李颜翎");

    private final InMemoryTransactionLog inMemoryTransactionLog = new InMemoryTransactionLog();
    private final FakeCreditCardProcessor fakeCreditCardProcessor = new FakeCreditCardProcessor();

    private final DatabaseTransactionLog databaseTransactionLog = new DatabaseTransactionLog();
    private final PaypalCreditCardProcessor paypalCreditCardProcessor = new PaypalCreditCardProcessor();


    /**
     * 构造函数进行注入，简单方便易测试
     */
    @org.junit.Test
    public void test1(){
        RealBillingService billingService = new RealBillingService(paypalCreditCardProcessor,databaseTransactionLog);
        Receipt receipt = billingService.chargeOrder(pizzaOrder, creditCard);
        System.out.println("收据："+receipt.toString());
    }

    /**
     * 构造函数进行注入，简单方便易测试
     */
    @org.junit.Test
    public void test2(){
        RealBillingService billingService = new RealBillingService(fakeCreditCardProcessor,inMemoryTransactionLog);
        Receipt receipt = billingService.chargeOrder(pizzaOrder, creditCard);
        System.out.println("收据："+receipt.toString());
    }
}
