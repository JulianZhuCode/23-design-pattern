package com.zhuzz.design.lab.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 基于 JDK ResourceBundle 的语言实现，文案由 .properties 资源文件维护。
 * Locale implementation backed by ResourceBundle and .properties files.
 */
public class ResourceBundleMessages implements I18nProvider {

    private final ResourceBundle bundle;
    private final Locale locale;

    public ResourceBundleMessages(ResourceBundle bundle, Locale locale) {
        this.bundle = bundle;
        this.locale = locale;
    }

    @Override
    public String get(I18nMessages key) {
        return bundle.containsKey(key.name()) ? bundle.getString(key.name()) : key.name();
    }

    @Override
    public String getLanguageName() {
        // 每种语言 properties 必须含 LANGUAGE_NAME 键 | Every bundle must define LANGUAGE_NAME
        return bundle.getString(I18nMessages.LANGUAGE_NAME.name());
    }

    @Override
    public Locale locale() {
        return locale;
    }
}