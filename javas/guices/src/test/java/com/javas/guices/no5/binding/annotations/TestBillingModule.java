package com.javas.guices.no5.binding.annotations;

import com.javas.guices.no5.binding.annotations.logger.Database;
import com.javas.guices.no5.binding.annotations.logger.TransactionLog;
import com.javas.guices.no5.binding.annotations.processor.CreditCardProcessor;
import com.javas.guices.no5.binding.annotations.processor.PayPal;

import com.google.inject.AbstractModule;

public class TestBillingModule extends AbstractModule{
    @Override
    protected void configure() {

        // @Database 注解标记过的，绑定到 InMemoryTransactionLog
        bind(TransactionLog.class).annotatedWith(Database.class).to(InMemoryTransactionLog.class);

        // @PayPal 注解标记过的，绑定到 FakeCreditCardProcessor
        bind(CreditCardProcessor.class).annotatedWith(PayPal.class).to(FakeCreditCardProcessor.class);

        // BillingService 绑定到 PaypalRealBillingService
        bind(BillingService.class).to(PaypalRealBillingService.class);
    }
}
