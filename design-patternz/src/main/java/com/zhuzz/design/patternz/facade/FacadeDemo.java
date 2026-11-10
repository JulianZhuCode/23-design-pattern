package com.zhuzz.design.patternz.facade;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class FacadeDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_FACADE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Home Theater", Locale.SIMPLIFIED_CHINESE, "家庭影院");
    }
    @Override public void run() { HomeTheaterCase.main(new String[0]); }
}