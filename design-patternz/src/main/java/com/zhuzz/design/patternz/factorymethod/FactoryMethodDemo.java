package com.zhuzz.design.patternz.factorymethod;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class FactoryMethodDemo implements DemoCase {
    @Override public I18nMessages category() { return CAT_CREATIONAL; }
    @Override public I18nMessages pattern() { return PAT_FACTORY_METHOD; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Shape Factory", Locale.SIMPLIFIED_CHINESE, "图形工厂");
    }
    @Override public void run() { ShapeFactoryCase.main(new String[0]); }
}