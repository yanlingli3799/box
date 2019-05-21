package com.javas.guices.no8.provides.methods.processor;


import com.javas.guices.no8.provides.methods.beans.ChargeResult;
import com.javas.guices.no8.provides.methods.beans.CreditCard;

public class PaypalCreditCardProcessor implements CreditCardProcessor {

    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String toString() {
        return "PaypalCreditCardProcessor{" +
                "apiKey='" + apiKey + '\'' +
                '}';
    }

//    @Inject
    public PaypalCreditCardProcessor(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public ChargeResult charge(CreditCard creditCard, long amount) {
        System.out.println("Paypal (key = "+apiKey+")"+creditCard.toString()+" 支付："+amount+"元");
        System.out.println("Paypal (key = "+apiKey+") 支付结果依赖第三方，这里假设每次都支付成功");
        System.out.println();
        return new ChargeResult(true,null);
    }
}
