package com.javas.guices.no2.motivation.beans;

public class PizzaOrder {
    // pizza 订单
    private long amount;

    public PizzaOrder(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
