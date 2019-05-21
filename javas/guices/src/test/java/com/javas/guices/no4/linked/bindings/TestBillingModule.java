package com.javas.guices.no4.linked.bindings;

import com.javas.guices.no4.linked.bindings.logger.TransactionLog;
import com.javas.guices.no4.linked.bindings.processor.CreditCardProcessor;

import com.google.inject.AbstractModule;

public class TestBillingModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(TransactionLog.class).to(InMemoryTransactionLog.class);
        bind(CreditCardProcessor.class).to(FakeCreditCardProcessor.class);
        bind(BillingService.class).to(RealBillingService.class);
    }
}
