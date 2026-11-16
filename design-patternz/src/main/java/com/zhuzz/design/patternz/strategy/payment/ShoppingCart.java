package com.zhuzz.design.patternz.strategy.payment;

/**
 * 上下文：购物车，持有支付策略并在结算时执行
 * Context: cart holding a payment strategy
 */
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            throw new IllegalStateException("No payment strategy set");
        }
    }
}