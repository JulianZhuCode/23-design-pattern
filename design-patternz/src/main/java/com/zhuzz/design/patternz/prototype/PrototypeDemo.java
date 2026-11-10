package com.zhuzz.design.patternz.prototype;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class PrototypeDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_CREATIONAL; }
    @Override public I18nMessages pattern() { return PAT_PROTOTYPE; }
    @Override public void run() { ShapeCloneCase.main(new String[0]); }
}