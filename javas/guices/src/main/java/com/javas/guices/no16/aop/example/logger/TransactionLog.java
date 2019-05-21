package com.javas.guices.no16.aop.example.logger;


import com.javas.guices.no16.aop.example.beans.ChargeResult;

public interface TransactionLog {

    public void logChargeResult(ChargeResult chargeResult);

    public void logConnectException(Exception e);
}
