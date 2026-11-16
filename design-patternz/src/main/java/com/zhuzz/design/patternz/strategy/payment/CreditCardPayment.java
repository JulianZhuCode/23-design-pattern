package com.zhuzz.design.patternz.strategy.payment;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体策略：信用卡支付
 * Concrete strategy: credit card payment
 */
public class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        Messages.println("payment.creditcard", amount, cardNumber);
    }
}