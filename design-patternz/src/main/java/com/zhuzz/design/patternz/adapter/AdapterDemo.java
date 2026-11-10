package com.zhuzz.design.patternz.adapter;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class AdapterDemo implements DemoCase {
    @Override public I18nMessages category() { return CAT_STRUCTURAL; }
    @Override public I18nMessages pattern() { return PAT_ADAPTER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Rectangle Adapter", Locale.SIMPLIFIED_CHINESE, "矩形适配");
    }
    @Override public void run() { RectangleAdapterCase.main(new String[0]); }
}