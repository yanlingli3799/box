package com.javas.guices.no16.aop.example.beans;

public class ChargeResult {

    private boolean isSuccess;
    private String declineMessage;

    public ChargeResult(boolean isSuccess, String declineMessage) {
        this.isSuccess = isSuccess;
        this.declineMessage = declineMessage;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getDeclineMessage() {
        return declineMessage;
    }

    public void setDeclineMessage(String declineMessage) {
        this.declineMessage = declineMessage;
    }

    @Override
    public String toString() {
        return "ChargeResult{" +
                "isSuccess=" + isSuccess +
                ", declineMessage='" + declineMessage + '\'' +
                '}';
    }
}
