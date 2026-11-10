package com.zhuzz.design.patternz.observer;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ObserverDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_OBSERVER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Number Observer", Locale.SIMPLIFIED_CHINESE, "数字观察");
    }
    @Override public void run() { NumberObserverCase.main(new String[0]); }
}