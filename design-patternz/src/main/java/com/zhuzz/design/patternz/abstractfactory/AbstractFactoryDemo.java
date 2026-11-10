package com.zhuzz.design.patternz.abstractfactory;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class AbstractFactoryDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_CREATIONAL; }
    @Override public I18nMessages pattern() { return PAT_ABSTRACT_FACTORY; }
    @Override public void run() { OfficeSuiteCase.main(new String[0]); }
}