package com.javas.guices.no9.provider.bindings;

import com.javas.guices.no9.provider.bindings.beans.CreditCard;
import com.javas.guices.no9.provider.bindings.beans.PizzaOrder;
import com.javas.guices.no9.provider.bindings.beans.Receipt;

public interface BillingService {
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
