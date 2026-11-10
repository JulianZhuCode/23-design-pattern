package com.zhuzz.design.patternz.builder;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class BuilderDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_CREATIONAL; }
    @Override public I18nMessages pattern() { return PAT_BUILDER; }
    @Override public void run() { HouseBuilderCase.main(new String[0]); }
}