package com.javas.guices.no16.aop.example;

import com.javas.guices.no16.aop.example.beans.CreditCard;
import com.javas.guices.no16.aop.example.beans.PizzaOrder;
import com.javas.guices.no16.aop.example.beans.Receipt;

public interface BillingService {
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
