package com.zhuzz.design.patternz.composite;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class CompositeDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_COMPOSITE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "File System", Locale.SIMPLIFIED_CHINESE, "文件系统");
    }
    @Override public void run() { FileSystemCase.main(new String[0]); }
}