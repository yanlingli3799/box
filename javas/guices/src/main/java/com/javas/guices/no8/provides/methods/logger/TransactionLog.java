package com.javas.guices.no8.provides.methods.logger;


import com.javas.guices.no8.provides.methods.beans.ChargeResult;

public interface TransactionLog {

    public void logChargeResult(ChargeResult chargeResult);

    public void logConnectException(Exception e);
}
