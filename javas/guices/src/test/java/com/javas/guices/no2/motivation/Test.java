package com.javas.guices.no2.motivation;

import com.javas.guices.no2.motivation.beans.CreditCard;
import com.javas.guices.no2.motivation.factories.CreditCardProcessorFactory;
import com.javas.guices.no2.motivation.factories.TransactionLogFactory;
import com.javas.guices.no2.motivation.logger.DatabaseTransactionLog;
import com.javas.guices.no2.motivation.beans.PizzaOrder;
import com.javas.guices.no2.motivation.beans.Receipt;
import com.javas.guices.no2.motivation.processor.PaypalCreditCardProcessor;

import junit.framework.TestCase;

public class Test extends TestCase{

    private final PizzaOrder pizzaOrder = new PizzaOrder(4);
    private final CreditCard creditCard = new CreditCard("123", "李颜翎");

    private final InMemoryTransactionLog inMemoryTransactionLog = new InMemoryTransactionLog();
    private final FakeCreditCardProcessor fakeCreditCardProcessor = new FakeCreditCardProcessor();


    private final DatabaseTransactionLog databaseTransactionLog    = new DatabaseTransactionLog();
    private final PaypalCreditCardProcessor paypalCreditCardProcessor = new PaypalCreditCardProcessor();


    @Override
    public void setUp(){
        TransactionLogFactory.setInstance(inMemoryTransactionLog);
        CreditCardProcessorFactory.setInstance(fakeCreditCardProcessor);
    }

    @Override
    public void tearDown(){
        TransactionLogFactory.setInstance(null);
        CreditCardProcessorFactory.setInstance(null);
    }

    /**
     * 使用假的银行卡，可以自由的在用例里模拟第三方返回的结果，而不必修改代码。
     * 但是实例由工厂管理，有点危险
     */
    @org.junit.Test
    public void test2(){
        RealBillingService billingService = new RealBillingService();
        Receipt receipt = billingService.chargeOrder(pizzaOrder, creditCard);
        System.out.println("收据："+receipt.toString());
        assertFalse(receipt.isPaySuccess());
        assertEquals(4, receipt.getReceiptAmount());

    }
}
