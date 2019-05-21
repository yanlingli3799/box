package com.javas.guices.no1.motivation;

import com.javas.guices.no1.motivation.beans.PizzaOrder;
import com.javas.guices.no1.motivation.beans.Receipt;
import com.javas.guices.no1.motivation.beans.CreditCard;

public interface BillingService {
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
