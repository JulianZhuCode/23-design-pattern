package com.zhuzz.design.patternz.singleton;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class SingletonDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_CREATIONAL; }
    @Override public I18nMessages pattern() { return PAT_SINGLETON; }
    @Override public void run() { InnerClassSingleton.main(new String[0]); }
}