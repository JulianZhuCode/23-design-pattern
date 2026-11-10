package com.zhuzz.design.lab.i18n;

import java.util.Locale;

public interface I18nProvider {
    String get(I18nMessages key);
    String getLanguageName();
    Locale locale();
}