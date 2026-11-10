package com.zhuzz.design.patternz.proxy;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ProxyDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_STRUCTURAL; }
    @Override public I18nMessages pattern() { return PAT_PROXY; }
    @Override public void run() { ImageProxyCase.main(new String[0]); }
}