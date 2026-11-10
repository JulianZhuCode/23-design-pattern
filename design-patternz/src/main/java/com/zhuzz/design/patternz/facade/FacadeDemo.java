package com.zhuzz.design.patternz.facade;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class FacadeDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_STRUCTURAL; }
    @Override public I18nMessages pattern() { return PAT_FACADE; }
    @Override public void run() { HomeTheaterCase.main(new String[0]); }
}