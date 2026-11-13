package com.zhuzz.design.lab.i18n;

import java.util.Locale;

/**
 * 语言提供者抽象：每种语言对应一个实现，负责按 key 取文案。
 * Language provider abstraction: one implementation per locale.
 */
public interface I18nProvider {
    /** 按文案 key 取当前语言文本。Get localized text by key. */
    String get(I18nMessages key);

    /** 语言显示名（用于语言下拉框）。Display name for the language selector. */
    String getLanguageName();

    /** 该实现对应的 Locale。The locale this provider represents. */
    Locale locale();
}