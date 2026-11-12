package com.zhuzz.design.lab.i18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class I18n {

    private static final List<I18nProvider> providers = new ArrayList<>();
    private static final List<Runnable> listeners = new ArrayList<>();
    /** 回退语言索引，固定为英文（注册在首位） | Fallback locale index (English first) */
    private static final int FALLBACK_INDEX = 0;
    private static int currentIndex = FALLBACK_INDEX;

    // 语言注册：新增语言需在此追加注册并新增 messages_<locale>.properties。
    // 索引顺序即语言列表顺序，首位固定为英文作为回退语言。
    // Register languages here; index order defines the list order (English first).
    static {
        register(new ResourceBundleMessages(ResourceBundle.getBundle("i18n.messages", Locale.ENGLISH), Locale.ENGLISH));
        register(new ResourceBundleMessages(ResourceBundle.getBundle("i18n.messages", Locale.SIMPLIFIED_CHINESE), Locale.SIMPLIFIED_CHINESE));
        applySystemLanguage();
    }

    /** 按系统 locale 选默认语言：精确匹配 → 语言匹配 → 英文 | Auto-select locale by system */
    private static void applySystemLanguage() {
        Locale system = Locale.getDefault();
        for (int i = 0; i < providers.size(); i++) {
            if (providers.get(i).locale().equals(system)) {
                currentIndex = i;
                return;
            }
        }
        String lang = system.getLanguage();
        for (int i = 0; i < providers.size(); i++) {
            if (providers.get(i).locale().getLanguage().equals(lang)) {
                currentIndex = i;
                return;
            }
        }
        currentIndex = FALLBACK_INDEX;
    }

    public static void register(I18nProvider provider) {
        providers.add(provider);
    }

    public static String get(I18nMessages key) {
        return providers.get(currentIndex).get(key);
    }

    public static void switchTo(int index) {
        int target = (index >= 0 && index < providers.size()) ? index : FALLBACK_INDEX;
        if (target != currentIndex) {
            currentIndex = target;
            listeners.forEach(Runnable::run);
        }
    }

    public static String getCurrentLanguageName() {
        return providers.get(currentIndex).getLanguageName();
    }

    public static Locale getCurrentLocale() {
        return providers.get(currentIndex).locale();
    }

    public static List<String> getAvailableLanguages() {
        return providers.stream().map(I18nProvider::getLanguageName).collect(Collectors.toList());
    }

    public static void onSwitch(Runnable callback) {
        listeners.add(callback);
    }
}