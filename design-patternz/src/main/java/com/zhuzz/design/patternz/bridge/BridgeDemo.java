package com.zhuzz.design.patternz.bridge;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class BridgeDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_STRUCTURAL; }
    @Override public I18nMessages pattern() { return PAT_BRIDGE; }
    @Override public void run() { ShapeColorCase.main(new String[0]); }
}