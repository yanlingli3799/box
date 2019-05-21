package com.javas.guices.no2.motivation.beans;

public class Receipt {

    private String receiptDesc;
    private long receiptAmount;
    private String declineMessage;
    private String systemMessage;
    private boolean isPaySuccess;

    private Receipt(String receiptDesc, long receiptAmount, String declineMessage, String systemMessage, boolean isPaySuccess) {
        this.receiptDesc = receiptDesc;
        this.receiptAmount = receiptAmount;
        this.declineMessage = declineMessage;
        this.systemMessage = systemMessage;
        this.isPaySuccess = isPaySuccess;
    }

    public boolean isPaySuccess() {
        return isPaySuccess;
    }

    public void setPaySuccess(boolean paySuccess) {
        isPaySuccess = paySuccess;
    }

    public String getReceiptDesc() {
        return receiptDesc;
    }

    public void setReceiptDesc(String receiptDesc) {
        this.receiptDesc = receiptDesc;
    }

    public long getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(long receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getDeclineMessage() {
        return declineMessage;
    }

    public void setDeclineMessage(String declineMessage) {
        this.declineMessage = declineMessage;
    }

    public String getSystemMessage() {
        return systemMessage;
    }

    public void setSystemMessage(String systemMessage) {
        this.systemMessage = systemMessage;
    }

    public static Receipt forSuccessfulCharge(long amount){
        return new Receipt("交易成功",amount,null,null,true);
    }

    public static Receipt forDeclinedCharge(long amount,String declineMessage){
        return new Receipt("交易失败",amount,declineMessage,null,false);
    }

    public static Receipt forSystemFailure(long amount,String systemMessage){
        return new Receipt("系统异常",amount,null,systemMessage,false);
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptDesc='" + receiptDesc + '\'' +
                ", receiptAmount=" + receiptAmount +
                ", declineMessage='" + declineMessage + '\'' +
                ", systemMessage='" + systemMessage + '\'' +
                ", isPaySuccess=" + isPaySuccess +
                '}';
    }
}
