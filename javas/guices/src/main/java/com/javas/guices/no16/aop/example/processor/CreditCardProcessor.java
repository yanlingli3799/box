package com.javas.guices.no16.aop.example.processor;


import com.javas.guices.no16.aop.example.beans.CreditCard;
import com.javas.guices.no16.aop.example.beans.ChargeResult;

public interface CreditCardProcessor {

    public ChargeResult charge(CreditCard creditCard, long amount);
}
