package com.zhuzz.design.lab.i18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class I18n {

    private static final List<I18nProvider> providers = new ArrayList<>();
    private static final List<Runnable> listeners = new ArrayList<>();
    /** 默认语言与未命中时的回退语言，固定为英文（注册在首位） */
    private static final int FALLBACK_INDEX = 0;
    private static int currentIndex = FALLBACK_INDEX;

    // 语言注册：新增语言需在此追加一个 ResourceBundleMessages 注册，
    // 并新增对应的 i18n/messages_<locale>.properties 文件。
    // 索引顺序即语言列表顺序，首位固定为英文作为默认与回退语言。
    static {
        register(new ResourceBundleMessages(ResourceBundle.getBundle("i18n.messages", Locale.ENGLISH), Locale.ENGLISH));
        register(new ResourceBundleMessages(ResourceBundle.getBundle("i18n.messages", Locale.SIMPLIFIED_CHINESE), Locale.SIMPLIFIED_CHINESE));
        applySystemLanguage();
    }

    /** 根据系统 locale 选择默认语言：优先精确匹配（语言+地区），其次按语言匹配，未命中则回退英文 */
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