package com.zhuzz.design.patternz.factorymethod;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class FactoryMethodDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_CREATIONAL; }
    @Override public I18nMessages pattern() { return PAT_FACTORY_METHOD; }
    @Override public void run() { ShapeFactoryCase.main(new String[0]); }
}