package com.zhuzz.design.patternz.flyweight;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class FlyweightDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_STRUCTURAL; }
    @Override public I18nMessages pattern() { return PAT_FLYWEIGHT; }
    @Override public void run() { CircleFlyweightCase.main(new String[0]); }
}