package com.javas.guices.no4.linked.bindings;

import com.javas.guices.no4.linked.bindings.logger.TransactionLog;
import com.javas.guices.no4.linked.bindings.processor.PaypalCreditCardProcessor;
import com.javas.guices.no4.linked.bindings.logger.DatabaseTransactionLog;
import com.javas.guices.no4.linked.bindings.processor.CreditCardProcessor;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
        bind(BillingService.class).to(RealBillingService.class);
    }
}
