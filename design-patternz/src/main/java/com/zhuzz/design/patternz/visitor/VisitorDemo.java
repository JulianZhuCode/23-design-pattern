package com.zhuzz.design.patternz.visitor;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class VisitorDemo implements DemoCase {
    @Override public I18nMessages category() { return CAT_BEHAVIORAL; }
    @Override public I18nMessages pattern() { return PAT_VISITOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Area Calculator", Locale.SIMPLIFIED_CHINESE, "面积计算");
    }
    @Override public void run() { AreaCalculatorCase.main(new String[0]); }
}