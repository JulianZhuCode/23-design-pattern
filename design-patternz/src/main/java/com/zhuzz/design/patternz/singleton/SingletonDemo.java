package com.zhuzz.design.patternz.singleton;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class SingletonDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_SINGLETON; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Static Inner Class", Locale.SIMPLIFIED_CHINESE, "静态内部类");
    }
    @Override public void run() { InnerClassSingleton.main(new String[0]); }
}