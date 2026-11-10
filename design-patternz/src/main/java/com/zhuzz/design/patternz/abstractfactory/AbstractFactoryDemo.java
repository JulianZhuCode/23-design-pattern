package com.zhuzz.design.patternz.abstractfactory;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class AbstractFactoryDemo implements DemoCase {
    @Override public I18nMessages category() { return CAT_CREATIONAL; }
    @Override public I18nMessages pattern() { return PAT_ABSTRACT_FACTORY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Office Suite", Locale.SIMPLIFIED_CHINESE, "办公套件");
    }
    @Override public void run() { OfficeSuiteCase.main(new String[0]); }
}