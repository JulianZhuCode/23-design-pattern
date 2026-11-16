package com.zhuzz.design.patternz.visitor.shoppingcart;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ShoppingCartDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_VISITOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Shopping Cart", Locale.SIMPLIFIED_CHINESE, "购物车");
    }
    @Override public void run() {
        Book book = new Book("Design Patterns", 59.99);
        Electronics phone = new Electronics("Smartphone", 999.00);

        PriceCalculator calculator = new PriceCalculator();
        book.accept(calculator);
        phone.accept(calculator);

        System.out.println("Total price: " + calculator.getTotal());
    }
}