package com.zhuzz.design.patternz.builder;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class BuilderDemo implements DemoCase {
    @Override public I18nMessages category() { return CAT_CREATIONAL; }
    @Override public I18nMessages pattern() { return PAT_BUILDER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "House Builder", Locale.SIMPLIFIED_CHINESE, "房屋建造");
    }
    @Override public void run() { HouseBuilderCase.main(new String[0]); }
}