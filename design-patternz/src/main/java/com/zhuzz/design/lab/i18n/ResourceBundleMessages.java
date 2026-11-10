package com.zhuzz.design.lab.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 基于 JDK 内置 ResourceBundle 的语言实现，
 * 文案由 classpath 下的 .properties 资源文件维护。
 */
public class ResourceBundleMessages implements I18nProvider {

    private final ResourceBundle bundle;

    public ResourceBundleMessages(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public String get(I18nMessages key) {
        return bundle.containsKey(key.name()) ? bundle.getString(key.name()) : key.name();
    }

    @Override
    public String getLanguageName() {
        // 约定：每种语言的 properties 必须包含 LANGUAGE_NAME 键
        return bundle.getString(I18nMessages.LANGUAGE_NAME.name());
    }

    @Override
    public Locale locale() {
        return bundle.getLocale();
    }
}