package com.zhuzz.design.patternz.templatemethod.beverage;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class BeverageDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_TEMPLATE_METHOD; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Beverage", Locale.SIMPLIFIED_CHINESE, "饮品制作");
    }
    @Override public void run() {
        Beverage coffee = new Coffee();
        coffee.prepareBeverage();

        Beverage tea = new Tea();
        tea.prepareBeverage();
    }
}