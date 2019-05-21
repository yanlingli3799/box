package com.javas.guices.no6.binding.named;

import com.javas.guices.no6.binding.named.logger.DatabaseTransactionLog;
import com.javas.guices.no6.binding.named.processor.PaypalCreditCardProcessor;
import com.javas.guices.no6.binding.named.logger.TransactionLog;
import com.javas.guices.no6.binding.named.processor.CreditCardProcessor;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class BillingModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(TransactionLog.class).annotatedWith(Names.named("Database")).to(DatabaseTransactionLog.class);

        bind(CreditCardProcessor.class).annotatedWith(Names.named("Paypal")).to(PaypalCreditCardProcessor.class);

        // 默认绑定 PaypalRealBillingService
        bind(BillingService.class).to(PaypalRealBillingService.class);
    }
}
