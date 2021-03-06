package com.javas.guices.no5.binding.annotations.logger;


import com.javas.guices.no5.binding.annotations.beans.ChargeResult;

public class DatabaseTransactionLog implements TransactionLog {

    @Override
    public void logChargeResult(ChargeResult chargeResult) {
        System.out.println("数据库 登记交易结果："+chargeResult.toString());
        System.out.println();
    }

    @Override
    public void logConnectException(Exception e) {
        System.out.println("数据库 登记连接异常："+e.toString());
        System.out.println();
    }
}
