package com.javas.guices.no8.provides.methods;

import com.javas.guices.no8.provides.methods.logger.TransactionLog;
import com.javas.guices.no8.provides.methods.processor.CreditCardProcessor;
import com.javas.guices.no8.provides.methods.processor.PayPal;
import com.javas.guices.no8.provides.methods.logger.Database;
import com.javas.guices.no8.provides.methods.logger.DatabaseTransactionLog;
import com.javas.guices.no8.provides.methods.processor.PaypalCreditCardProcessor;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class BillingModule extends AbstractModule{

    @Override
    protected void configure() {

        bind(String.class)
                .annotatedWith(Names.named("name jdbcUrl"))
                .toInstance("jdbc:mysql://localhost/pizza");

        bind(String.class)
                .annotatedWith(Names.named("name apiKey"))
                .toInstance("paypalapikey");

        // 默认绑定 PaypalRealBillingService
        bind(BillingService.class).to(PaypalRealBillingService.class);
    }


    @Provides @Database
    TransactionLog provideTransactionLog(@Named("name jdbcUrl") String jdbcUrl){
        System.out.println("@Provider.. provide TransactionLog ....");
        return new DatabaseTransactionLog(jdbcUrl);
    }

    @Provides @PayPal
    CreditCardProcessor provideCreditCardProcessor(@Named("name apiKey") String apiKey){
        System.out.println("@Provider.. provide CreditCardProcessor....");
        return new PaypalCreditCardProcessor(apiKey);
    }
}
