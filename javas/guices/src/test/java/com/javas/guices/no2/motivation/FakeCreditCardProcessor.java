package com.javas.guices.no2.motivation;

import com.javas.guices.no2.motivation.beans.ChargeResult;
import com.javas.guices.no2.motivation.beans.CreditCard;
import com.javas.guices.no2.motivation.processor.CreditCardProcessor;

public class FakeCreditCardProcessor implements CreditCardProcessor{

    @Override
    public ChargeResult charge(CreditCard creditCard, long amount) {
        System.out.println("假信用卡 "+creditCard.toString()+" 支付："+amount+"元");
        System.out.println("假信用卡 模拟支付失败");
        System.out.println();
        return new ChargeResult(false,"银行卡号长度不正确");
    }
}
