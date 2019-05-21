package com.javas.guices.no9.provider.bindings;

import com.javas.guices.no9.provider.bindings.logger.Database;
import com.javas.guices.no9.provider.bindings.logger.DatabaseTransactionLogProvider;
import com.javas.guices.no9.provider.bindings.processor.PayPal;
import com.javas.guices.no9.provider.bindings.processor.PaypalCreditCardProcessorProvider;
import com.javas.guices.no9.provider.bindings.logger.TransactionLog;
import com.javas.guices.no9.provider.bindings.processor.CreditCardProcessor;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class BillingModule extends AbstractModule{

    @Override
    protected void configure() {

        bind(TransactionLog.class)
                .annotatedWith(Database.class)
                .toProvider(DatabaseTransactionLogProvider.class);

        bind(CreditCardProcessor.class)
                .annotatedWith(PayPal.class)
                .toProvider(PaypalCreditCardProcessorProvider.class);

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
