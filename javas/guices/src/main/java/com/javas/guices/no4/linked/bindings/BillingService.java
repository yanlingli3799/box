package com.javas.guices.no4.linked.bindings;

import com.javas.guices.no4.linked.bindings.beans.CreditCard;
import com.javas.guices.no4.linked.bindings.beans.PizzaOrder;
import com.javas.guices.no4.linked.bindings.beans.Receipt;

public interface BillingService {
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
