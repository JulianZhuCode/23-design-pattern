package com.zhuzz.design.patternz.proxy;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ProxyDemo implements DemoCase {
    @Override public I18nMessages category() { return CAT_STRUCTURAL; }
    @Override public I18nMessages pattern() { return PAT_PROXY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Lazy Image", Locale.SIMPLIFIED_CHINESE, "图片延迟加载");
    }
    @Override public void run() { ImageProxyCase.main(new String[0]); }
}