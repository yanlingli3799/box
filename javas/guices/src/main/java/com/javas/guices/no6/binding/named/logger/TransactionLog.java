package com.javas.guices.no6.binding.named.logger;


import com.javas.guices.no6.binding.named.beans.ChargeResult;

public interface TransactionLog {

    public void logChargeResult(ChargeResult chargeResult);

    public void logConnectException(Exception e);
}
