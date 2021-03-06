package com.javas.guices.no3.motivation;

import com.javas.guices.no3.motivation.logger.TransactionLog;
import com.javas.guices.no3.motivation.beans.ChargeResult;

public class InMemoryTransactionLog implements TransactionLog {
    @Override
    public void logChargeResult(ChargeResult chargeResult) {
        System.out.println("内存 登记交易结果："+chargeResult.toString());
        System.out.println();
    }

    @Override
    public void logConnectException(Exception e) {
        System.out.println("内存 登记操作异常："+e.toString());
        System.out.println();
    }
}
