package com.zhuzz.design.patternz.strategy;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class StrategyDemo implements DemoCase {
    @Override public I18nMessages category() { return CAT_BEHAVIORAL; }
    @Override public I18nMessages pattern() { return PAT_STRATEGY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Calculator", Locale.SIMPLIFIED_CHINESE, "计算器策略");
    }
    @Override public void run() { CalculatorCase.main(new String[0]); }
}