package com.javas.guices.no6.binding.named;

import com.javas.guices.no6.binding.named.beans.PizzaOrder;
import com.javas.guices.no6.binding.named.beans.CreditCard;
import com.javas.guices.no6.binding.named.beans.Receipt;

public interface BillingService {
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
