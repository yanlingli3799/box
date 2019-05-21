package com.javas.guices.no5.binding.annotations.processor;


import com.javas.guices.no5.binding.annotations.beans.ChargeResult;
import com.javas.guices.no5.binding.annotations.beans.CreditCard;

public interface CreditCardProcessor {

    public ChargeResult charge(CreditCard creditCard, long amount);
}
