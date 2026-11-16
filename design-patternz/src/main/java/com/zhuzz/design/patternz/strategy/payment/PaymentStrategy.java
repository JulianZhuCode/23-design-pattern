package com.zhuzz.design.patternz.strategy.payment;

/**
 * 策略接口：声明支付方式
 * Strategy: declares payment method
 */
public interface PaymentStrategy {
    void pay(double amount);
}