package com.javas.guices.no4.linked.bindings;

import com.javas.guices.no4.linked.bindings.beans.ChargeResult;
import com.javas.guices.no4.linked.bindings.beans.CreditCard;
import com.javas.guices.no4.linked.bindings.beans.PizzaOrder;
import com.javas.guices.no4.linked.bindings.beans.Receipt;
import com.javas.guices.no4.linked.bindings.logger.TransactionLog;
import com.javas.guices.no4.linked.bindings.processor.CreditCardProcessor;

import com.google.inject.Inject;

public class RealBillingService implements BillingService {

    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;

    @Inject
    public RealBillingService(CreditCardProcessor processor, TransactionLog transactionLog) {
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
