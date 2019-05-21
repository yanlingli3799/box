package com.javas.guices.no3.motivation;

import com.javas.guices.no3.motivation.beans.Receipt;
import com.javas.guices.no3.motivation.beans.CreditCard;
import com.javas.guices.no3.motivation.beans.PizzaOrder;

public interface BillingService {
    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
