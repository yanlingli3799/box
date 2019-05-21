package com.javas.guices.no8.provides.methods;

import com.javas.guices.no8.provides.methods.beans.CreditCard;
import com.javas.guices.no8.provides.methods.beans.PizzaOrder;
import com.javas.guices.no8.provides.methods.beans.Receipt;

public interface BillingService {
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
