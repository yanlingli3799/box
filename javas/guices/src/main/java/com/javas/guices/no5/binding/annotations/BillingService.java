package com.javas.guices.no5.binding.annotations;

import com.javas.guices.no5.binding.annotations.beans.CreditCard;
import com.javas.guices.no5.binding.annotations.beans.PizzaOrder;
import com.javas.guices.no5.binding.annotations.beans.Receipt;

public interface BillingService {
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
