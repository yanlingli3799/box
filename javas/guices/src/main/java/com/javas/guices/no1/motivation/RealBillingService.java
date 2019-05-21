package com.javas.guices.no1.motivation;

import com.javas.guices.no1.motivation.beans.ChargeResult;
import com.javas.guices.no1.motivation.beans.CreditCard;
import com.javas.guices.no1.motivation.beans.Receipt;
import com.javas.guices.no1.motivation.logger.TransactionLog;
import com.javas.guices.no1.motivation.processor.CreditCardProcessor;
import com.javas.guices.no1.motivation.processor.PaypalCreditCardProcessor;
import com.javas.guices.no1.motivation.beans.PizzaOrder;
import com.javas.guices.no1.motivation.logger.DatabaseTransactionLog;

public class RealBillingService implements BillingService {

    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        // 看这里，new 一个Processor实例，和一个 TransactionLog 实例
        CreditCardProcessor processor = new PaypalCreditCardProcessor();
        TransactionLog transactionLog = new DatabaseTransactionLog();

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
