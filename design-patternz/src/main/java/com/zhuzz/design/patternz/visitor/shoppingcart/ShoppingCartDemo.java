package com.zhuzz.design.patternz.visitor.shoppingcart;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ShoppingCartDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_VISITOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Shopping Cart", Locale.SIMPLIFIED_CHINESE, "购物车");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        Book book = new Book("Design Patterns", 59.99);
        Electronics phone = new Electronics("Smartphone", 999.00);

        PriceCalculator calculator = new PriceCalculator();
        book.accept(calculator);
        phone.accept(calculator);

        Messages.println("cart.total", calculator.getTotal());
    }
}