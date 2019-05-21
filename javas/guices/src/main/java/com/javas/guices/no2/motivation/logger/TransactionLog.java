package com.javas.guices.no2.motivation.logger;

import com.javas.guices.no2.motivation.beans.ChargeResult;

public interface TransactionLog {

    public void logChargeResult(ChargeResult chargeResult);

    public void logConnectException(Exception e);
}
