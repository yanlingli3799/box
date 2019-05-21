package com.javas.guices.no15.injecting.providers.logger;


import com.javas.guices.no15.injecting.providers.beans.ChargeResult;

public interface TransactionLog {

    public void logChargeResult(ChargeResult chargeResult);

    public void logConnectException(Exception e);
}
