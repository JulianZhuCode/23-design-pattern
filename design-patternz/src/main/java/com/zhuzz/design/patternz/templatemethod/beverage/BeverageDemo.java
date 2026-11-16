package com.zhuzz.design.patternz.templatemethod.beverage;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class BeverageDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_TEMPLATE_METHOD; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Beverage", Locale.SIMPLIFIED_CHINESE, "饮品制作");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        Beverage coffee = new Coffee();
        coffee.prepareBeverage();

        Beverage tea = new Tea();
        tea.prepareBeverage();
    }
}