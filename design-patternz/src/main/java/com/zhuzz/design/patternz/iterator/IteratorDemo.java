package com.zhuzz.design.patternz.iterator;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class IteratorDemo implements DemoCase {
    @Override public I18nMessages category() { return CAT_BEHAVIORAL; }
    @Override public I18nMessages pattern() { return PAT_ITERATOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Collection Iterator", Locale.SIMPLIFIED_CHINESE, "集合遍历");
    }
    @Override public void run() { CollectionIterationCase.main(new String[0]); }
}