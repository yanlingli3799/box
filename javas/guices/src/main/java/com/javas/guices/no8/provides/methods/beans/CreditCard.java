package com.javas.guices.no8.provides.methods.beans;

public class CreditCard {
    private String cardNo;
    private String name;

    public CreditCard(String cardNo, String name) {
        this.cardNo = cardNo;
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNo='" + cardNo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
