package com.javas.guices.no16.aop.example.logger;


import com.javas.guices.no16.aop.example.beans.ChargeResult;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class DatabaseTransactionLog implements TransactionLog {

    private String jdbcUrl;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    @Override
    public String toString() {
        return "DatabaseTransactionLog{" +
                "jdbcUrl='" + jdbcUrl + '\'' +
                '}';
    }
    
    @Inject
    public DatabaseTransactionLog(@Named("name jdbcUrl") String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    @Override
    public void logChargeResult(ChargeResult chargeResult) {
        System.out.println("数据库 "+jdbcUrl+" 登记交易结果："+chargeResult.toString());
        System.out.println();
    }

    @Override
    public void logConnectException(Exception e) {
        System.out.println("数据库 "+jdbcUrl+" 登记连接异常："+e.toString());
        System.out.println();
    }
}
