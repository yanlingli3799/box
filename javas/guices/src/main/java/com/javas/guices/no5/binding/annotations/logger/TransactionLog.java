package com.javas.guices.no5.binding.annotations.logger;


import com.javas.guices.no5.binding.annotations.beans.ChargeResult;

public interface TransactionLog {

    public void logChargeResult(ChargeResult chargeResult);

    public void logConnectException(Exception e);
}
