package com.javas.guices.no9.provider.bindings.processor;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class PaypalCreditCardProcessorProvider implements Provider<CreditCardProcessor> {

    private String apiKey;

    @Inject
    public PaypalCreditCardProcessorProvider(@Named("name apiKey") String apiKey){
        this.apiKey=apiKey;
    }
    @Override
    public CreditCardProcessor get() {
        return new PaypalCreditCardProcessor(apiKey);
    }
}
