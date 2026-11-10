package com.zhuzz.design.patternz.bridge;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class BridgeDemo implements DemoCase {
    @Override public I18nMessages category() { return CAT_STRUCTURAL; }
    @Override public I18nMessages pattern() { return PAT_BRIDGE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Shape & Color", Locale.SIMPLIFIED_CHINESE, "图形着色");
    }
    @Override public void run() { ShapeColorCase.main(new String[0]); }
}