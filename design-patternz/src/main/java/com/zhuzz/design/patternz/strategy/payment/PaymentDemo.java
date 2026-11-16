package com.zhuzz.design.patternz.strategy.payment;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class PaymentDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_STRATEGY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Payment", Locale.SIMPLIFIED_CHINESE, "支付方式");
    }
    @Override public void run() {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment("1234-5678"));
        cart.checkout(120.50);

        cart.setPaymentStrategy(new PayPalPayment("alice@example.com"));
        cart.checkout(89.00);

        cart.setPaymentStrategy(new WeChatPayment("alice_wx"));
        cart.checkout(45.00);
    }
}