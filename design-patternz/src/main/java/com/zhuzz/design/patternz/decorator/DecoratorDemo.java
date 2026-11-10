package com.zhuzz.design.patternz.decorator;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class DecoratorDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_DECORATOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Coffee Topping", Locale.SIMPLIFIED_CHINESE, "咖啡加料");
    }
    @Override public void run() { CoffeeDecoratorCase.main(new String[0]); }
}