package com.javas.guices.no2.motivation.factories;

import com.javas.guices.no2.motivation.logger.DatabaseTransactionLog;
import com.javas.guices.no2.motivation.logger.TransactionLog;

public class TransactionLogFactory {

    private static TransactionLog instance;

    // 设置一个 TransactionLog 实例
    public static void setInstance(TransactionLog logger) {
        instance = logger;
    }
    // 获取 TransactionLog 实例
    public static TransactionLog getInstance() {
        if (instance == null) {
            return new DatabaseTransactionLog();
        }
        return instance;
    }

}
