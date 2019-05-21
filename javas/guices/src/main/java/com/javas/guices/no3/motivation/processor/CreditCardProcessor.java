package com.javas.guices.no3.motivation.processor;


import com.javas.guices.no3.motivation.beans.ChargeResult;
import com.javas.guices.no3.motivation.beans.CreditCard;

public interface CreditCardProcessor {

    public ChargeResult charge(CreditCard creditCard, long amount);
}
