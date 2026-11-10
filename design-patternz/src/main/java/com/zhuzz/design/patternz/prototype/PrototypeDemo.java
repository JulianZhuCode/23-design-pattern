package com.zhuzz.design.patternz.prototype;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class PrototypeDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_PROTOTYPE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Shape Clone", Locale.SIMPLIFIED_CHINESE, "图形克隆");
    }
    @Override public void run() { ShapeCloneCase.main(new String[0]); }
}