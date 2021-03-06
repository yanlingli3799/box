package com.javas.guices.no15.injecting.providers;

import com.javas.guices.no15.injecting.providers.beans.ChargeResult;
import com.javas.guices.no15.injecting.providers.beans.CreditCard;
import com.javas.guices.no15.injecting.providers.beans.PizzaOrder;
import com.javas.guices.no15.injecting.providers.beans.Receipt;
import com.javas.guices.no15.injecting.providers.logger.TransactionLog;
import com.javas.guices.no15.injecting.providers.processor.CreditCardProcessor;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class PaypalRealBillingService implements BillingService {

    private final Provider<CreditCardProcessor> creditCardProcessorProvider;
    private final Provider<TransactionLog> transactionLogProvider;

    @Inject
    public PaypalRealBillingService(Provider<CreditCardProcessor> creditCardProcessorProvider, Provider<TransactionLog> transactionLogProvider) {
        this.creditCardProcessorProvider = creditCardProcessorProvider;
        this.transactionLogProvider = transactionLogProvider;
    }

    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        // 每次在 Provider.get() 都会获取一个新的实例
        CreditCardProcessor creditCardProcessor = creditCardProcessorProvider.get();
        TransactionLog transactionLog = transactionLogProvider.get();
        try {
            ChargeResult result = creditCardProcessor.charge(creditCard, order.getAmount());
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
