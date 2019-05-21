package com.javas.guices.no16.aop.example;

import com.javas.guices.no16.aop.example.logger.DatabaseTransactionLog;
import com.javas.guices.no16.aop.example.logger.TransactionLog;
import com.javas.guices.no16.aop.example.processor.CreditCardProcessor;
import com.javas.guices.no16.aop.example.processor.PaypalCreditCardProcessor;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class BillingModule extends AbstractModule{

    @Override
    protected void configure() {

        bind(TransactionLog.class).to(DatabaseTransactionLog.class);

        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);

        bind(String.class)
                .annotatedWith(Names.named("name jdbcUrl"))
                .toInstance("jdbc:mysql://localhost/pizza");

        bind(String.class)
                .annotatedWith(Names.named("name apiKey"))
                .toInstance("paypalapikey");

        // 默认绑定 PaypalRealBillingService
        bind(BillingService.class).to(PaypalRealBillingService.class);
    }
}
