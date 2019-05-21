package com.javas.guices.no6.binding.named.processor;


import com.javas.guices.no6.binding.named.beans.ChargeResult;
import com.javas.guices.no6.binding.named.beans.CreditCard;

public class PaypalCreditCardProcessor implements CreditCardProcessor {

    @Override
    public ChargeResult charge(CreditCard creditCard, long amount) {
        System.out.println("Paypal "+creditCard.toString()+" 支付："+amount+"元");
        System.out.println("Paypal 支付结果依赖第三方，这里假设每次都支付成功");
        System.out.println();
        return new ChargeResult(true,null);
    }
}
