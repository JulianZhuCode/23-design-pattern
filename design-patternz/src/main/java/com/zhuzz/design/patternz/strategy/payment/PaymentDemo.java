package com.zhuzz.design.patternz.strategy.payment;

import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;
import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class PaymentDemo extends DemoSupport {
    @Override public I18nMessages pattern() { return PAT_STRATEGY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Payment", Locale.SIMPLIFIED_CHINESE, "支付方式");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(
                new PlaygroundInput(
                        "method",
                        Map.of(Locale.ENGLISH, "Payment Method", Locale.SIMPLIFIED_CHINESE, "支付方式"),
                        PlaygroundInput.Type.CHOICE,
                        List.of("CreditCard", "PayPal", "WeChat"),
                        "CreditCard"),
                new PlaygroundInput(
                        "amount",
                        Map.of(Locale.ENGLISH, "Amount", Locale.SIMPLIFIED_CHINESE, "支付金额"),
                        PlaygroundInput.Type.TEXT,
                        List.of(),
                        "120.50"));
    }

    @Override public void run(Map<String, String> values) {
        ShoppingCart cart = new ShoppingCart();

        // 按用户选择的支付方式与金额完成一次结算
        // checkout once with the user-selected payment method and amount
        String method = values.getOrDefault("method", "CreditCard");
        if ("PayPal".equals(method)) {
            cart.setPaymentStrategy(new PayPalPayment("alice@example.com"));
        } else if ("WeChat".equals(method)) {
            cart.setPaymentStrategy(new WeChatPayment("alice_wx"));
        } else {
            cart.setPaymentStrategy(new CreditCardPayment("1234-5678"));
        }
        // 金额必须为数字，非法输入给出友好提示并中止
        // Amount must be numeric; abort with a friendly hint on invalid input
        double amount;
        try {
            amount = Double.parseDouble(values.getOrDefault("amount", "120.50"));
        } catch (NumberFormatException e) {
            Messages.println("payment.invalidAmount");
            return;
        }
        cart.checkout(amount);
    }
}