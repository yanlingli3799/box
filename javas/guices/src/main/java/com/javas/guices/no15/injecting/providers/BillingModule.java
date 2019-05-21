package com.javas.guices.no15.injecting.providers;

import com.javas.guices.no15.injecting.providers.logger.DatabaseTransactionLog;
import com.javas.guices.no15.injecting.providers.logger.TransactionLog;
import com.javas.guices.no15.injecting.providers.processor.CreditCardProcessor;
import com.javas.guices.no15.injecting.providers.processor.PaypalCreditCardProcessor;

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
