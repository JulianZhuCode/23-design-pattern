package com.zhuzz.design.patternz.flyweight;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class FlyweightDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_FLYWEIGHT; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Circle Pool", Locale.SIMPLIFIED_CHINESE, "圆形共享");
    }
    @Override public void run() { CircleFlyweightCase.main(new String[0]); }
}