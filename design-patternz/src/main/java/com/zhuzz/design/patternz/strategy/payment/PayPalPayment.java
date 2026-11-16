package com.zhuzz.design.patternz.strategy.payment;

/**
 * 具体策略：PayPal 支付
 * Concrete strategy: PayPal payment
 */
public class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via PayPal " + email);
    }
}