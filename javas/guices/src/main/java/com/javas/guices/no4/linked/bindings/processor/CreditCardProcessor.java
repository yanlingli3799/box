package com.javas.guices.no4.linked.bindings.processor;


import com.javas.guices.no4.linked.bindings.beans.ChargeResult;
import com.javas.guices.no4.linked.bindings.beans.CreditCard;

public interface CreditCardProcessor {

    public ChargeResult charge(CreditCard creditCard, long amount);
}
