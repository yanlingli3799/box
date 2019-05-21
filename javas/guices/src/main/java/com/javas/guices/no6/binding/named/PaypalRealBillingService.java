package com.javas.guices.no6.binding.named;

import com.javas.guices.no6.binding.named.beans.PizzaOrder;
import com.javas.guices.no6.binding.named.beans.Receipt;
import com.javas.guices.no6.binding.named.processor.CreditCardProcessor;
import com.javas.guices.no6.binding.named.beans.ChargeResult;
import com.javas.guices.no6.binding.named.beans.CreditCard;
import com.javas.guices.no6.binding.named.logger.TransactionLog;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class PaypalRealBillingService implements BillingService {

    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;

    @Inject
    public PaypalRealBillingService(@Named("Paypal") CreditCardProcessor processor, @Named("Database") TransactionLog transactionLog) {
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
