package com.javas.guices.no9.provider.bindings.logger;


import com.javas.guices.no9.provider.bindings.beans.ChargeResult;

public interface TransactionLog {

    public void logChargeResult(ChargeResult chargeResult);

    public void logConnectException(Exception e);
}
