package com.javas.guices.no8.provides.methods;

import com.javas.guices.no8.provides.methods.beans.ChargeResult;
import com.javas.guices.no8.provides.methods.beans.CreditCard;
import com.javas.guices.no8.provides.methods.beans.PizzaOrder;
import com.javas.guices.no8.provides.methods.beans.Receipt;
import com.javas.guices.no8.provides.methods.logger.Database;
import com.javas.guices.no8.provides.methods.logger.TransactionLog;
import com.javas.guices.no8.provides.methods.processor.CreditCardProcessor;
import com.javas.guices.no8.provides.methods.processor.PayPal;

import com.google.inject.Inject;

public class PaypalRealBillingService implements BillingService {

    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;


    @Inject
    public PaypalRealBillingService(@PayPal CreditCardProcessor processor, @Database TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }


    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        try {
            ChargeResult result = processor.charge(creditCard, order.getAmount());
            transactionLog.logChargeResult(result);
            return result.isSuccess()
                    ? Receipt.forSuccessfulCharge(order.getAmount())
                    : Receipt.forDeclinedCharge(order.getAmount(),result.getDeclineMessage());
        } catch (Exception e) {
            transactionLog.logConnectException(e);
            return Receipt.forSystemFailure(order.getAmount(),e.getMessage());
        }

    }
}
