package com.javas.guices.no15.injecting.providers;

import com.javas.guices.no15.injecting.providers.beans.PizzaOrder;
import com.javas.guices.no15.injecting.providers.beans.CreditCard;
import com.javas.guices.no15.injecting.providers.beans.Receipt;

public interface BillingService {
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
