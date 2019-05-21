package com.javas.guices.no3.motivation;

import com.javas.guices.no3.motivation.beans.ChargeResult;
import com.javas.guices.no3.motivation.beans.CreditCard;
import com.javas.guices.no3.motivation.beans.PizzaOrder;
import com.javas.guices.no3.motivation.beans.Receipt;
import com.javas.guices.no3.motivation.logger.TransactionLog;
import com.javas.guices.no3.motivation.processor.CreditCardProcessor;

public class RealBillingService implements BillingService{

    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;

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
