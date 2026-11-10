package com.zhuzz.design.patternz.adapter;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class AdapterDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_STRUCTURAL; }
    @Override public I18nMessages pattern() { return PAT_ADAPTER; }
    @Override public void run() { RectangleAdapterCase.main(new String[0]); }
}