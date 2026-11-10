package com.zhuzz.design.patternz.observer;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ObserverDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_BEHAVIORAL; }
    @Override public I18nMessages pattern() { return PAT_OBSERVER; }
    @Override public void run() { NumberObserverCase.main(new String[0]); }
}