package com.javas.guices.no4.linked.bindings.logger;


import com.javas.guices.no4.linked.bindings.beans.ChargeResult;

public interface TransactionLog {

    public void logChargeResult(ChargeResult chargeResult);

    public void logConnectException(Exception e);
}
