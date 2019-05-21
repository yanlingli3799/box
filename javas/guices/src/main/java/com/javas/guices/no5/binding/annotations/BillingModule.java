package com.javas.guices.no5.binding.annotations;

import com.javas.guices.no5.binding.annotations.logger.Database;
import com.javas.guices.no5.binding.annotations.logger.DatabaseTransactionLog;
import com.javas.guices.no5.binding.annotations.logger.TransactionLog;
import com.javas.guices.no5.binding.annotations.processor.CreditCardProcessor;
import com.javas.guices.no5.binding.annotations.processor.PayPal;
import com.javas.guices.no5.binding.annotations.processor.PaypalCreditCardProcessor;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(TransactionLog.class).annotatedWith(Database.class).to(DatabaseTransactionLog.class);

        bind(CreditCardProcessor.class).annotatedWith(PayPal.class).to(PaypalCreditCardProcessor.class);

        // 默认绑定 PaypalRealBillingService
        bind(BillingService.class).to(PaypalRealBillingService.class);
    }
}
