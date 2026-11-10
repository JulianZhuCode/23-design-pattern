package com.zhuzz.design.patternz.memento;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class MementoDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_MEMENTO; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Text Editor", Locale.SIMPLIFIED_CHINESE, "文本编辑器");
    }
    @Override public void run() { TextEditorCase.main(new String[0]); }
}