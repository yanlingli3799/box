package com.javas.guices.no8.provides.methods.processor;


import com.javas.guices.no8.provides.methods.beans.ChargeResult;
import com.javas.guices.no8.provides.methods.beans.CreditCard;

public interface CreditCardProcessor {

    public ChargeResult charge(CreditCard creditCard, long amount);
}
