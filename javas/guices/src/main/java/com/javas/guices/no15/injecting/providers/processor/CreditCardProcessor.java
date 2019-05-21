package com.javas.guices.no15.injecting.providers.processor;


import com.javas.guices.no15.injecting.providers.beans.CreditCard;
import com.javas.guices.no15.injecting.providers.beans.ChargeResult;

public interface CreditCardProcessor {

    public ChargeResult charge(CreditCard creditCard, long amount);
}
