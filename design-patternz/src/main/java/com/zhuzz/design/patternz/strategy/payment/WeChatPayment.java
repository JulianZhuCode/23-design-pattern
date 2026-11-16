package com.zhuzz.design.patternz.strategy.payment;

import com.zhuzz.design.lab.i18n.Messages;

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
        Messages.println("payment.wechat", amount, account);
    }
}