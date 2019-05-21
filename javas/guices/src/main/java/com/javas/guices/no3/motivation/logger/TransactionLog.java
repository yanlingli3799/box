package com.javas.guices.no3.motivation.logger;


import com.javas.guices.no3.motivation.beans.ChargeResult;

public interface TransactionLog {

    public void logChargeResult(ChargeResult chargeResult);

    public void logConnectException(Exception e);
}
