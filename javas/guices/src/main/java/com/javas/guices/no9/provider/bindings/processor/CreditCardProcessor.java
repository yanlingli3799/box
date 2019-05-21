package com.javas.guices.no9.provider.bindings.processor;


import com.javas.guices.no9.provider.bindings.beans.ChargeResult;
import com.javas.guices.no9.provider.bindings.beans.CreditCard;

public interface CreditCardProcessor {

    public ChargeResult charge(CreditCard creditCard, long amount);
}
