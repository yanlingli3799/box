package com.javas.guices.no2.motivation;

import com.javas.guices.no2.motivation.beans.ChargeResult;
import com.javas.guices.no2.motivation.beans.CreditCard;
import com.javas.guices.no2.motivation.beans.PizzaOrder;
import com.javas.guices.no2.motivation.beans.Receipt;
import com.javas.guices.no2.motivation.factories.TransactionLogFactory;
import com.javas.guices.no2.motivation.logger.TransactionLog;
import com.javas.guices.no2.motivation.processor.CreditCardProcessor;
import com.javas.guices.no2.motivation.factories.CreditCardProcessorFactory;

public class RealBillingService implements BillingService{

    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        // 看这里，从工厂里获取实例
        CreditCardProcessor processor = CreditCardProcessorFactory.getInstance();
        TransactionLog transactionLog = TransactionLogFactory.getInstance();

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
