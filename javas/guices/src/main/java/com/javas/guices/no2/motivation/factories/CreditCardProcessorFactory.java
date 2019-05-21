package com.javas.guices.no2.motivation.factories;

import com.javas.guices.no2.motivation.processor.CreditCardProcessor;
import com.javas.guices.no2.motivation.processor.PaypalCreditCardProcessor;

public class CreditCardProcessorFactory {

    private static CreditCardProcessor instance;
    // 设置一个 CreditCardProcessor 实例
    public static void setInstance(CreditCardProcessor processor) {
        instance = processor;
    }
    // 获取 CreditCardProcessor 实例
    public static CreditCardProcessor getInstance() {
        if (instance == null) {
            return new PaypalCreditCardProcessor();
        }
        return instance;
    }


}
