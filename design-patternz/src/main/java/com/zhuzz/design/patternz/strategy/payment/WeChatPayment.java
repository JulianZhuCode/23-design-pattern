package com.zhuzz.design.patternz.strategy.payment;

/**
 * 具体策略：微信支付
 * Concrete strategy: WeChat payment
 */
public class WeChatPayment implements PaymentStrategy {
    private final String account;

    public WeChatPayment(String account) {
        this.account = account;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via WeChat " + account);
    }
}