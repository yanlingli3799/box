package com.javas.guices.no6.binding.named.processor;


import com.javas.guices.no6.binding.named.beans.ChargeResult;
import com.javas.guices.no6.binding.named.beans.CreditCard;

public interface CreditCardProcessor {

    public ChargeResult charge(CreditCard creditCard, long amount);
}
