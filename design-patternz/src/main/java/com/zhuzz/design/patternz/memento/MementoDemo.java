package com.zhuzz.design.patternz.memento;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class MementoDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_BEHAVIORAL; }
    @Override public I18nMessages pattern() { return PAT_MEMENTO; }
    @Override public void run() { TextEditorCase.main(new String[0]); }
}