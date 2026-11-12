package com.zhuzz.design.lab;

import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

/**
 * 设计模式案例接口：声明案例的分类、多语言显示名与运行入口。
 * 案例通过扫描案例根包自动发现，无需注册文件。
 * Demo case interface: declares category, localized names and the run entry.
 * Cases are auto-discovered by scanning the root package.
 */
public interface DemoCase {

    I18nMessages pattern();

    /** 所属分类，由 pattern() 推导 | Category derived from pattern() */
    default I18nMessages category() {
        return pattern().category();
    }

    /** 显示名多语言映射：key 为语言，value 为显示值 | Localized display names */
    Map<Locale, String> caseNames();

    void run();

    /** 按语言取显示名，回退链：指定语言 → 英文 → 类名 | Resolve name with fallback */
    default String caseName(Locale locale) {
        return caseNames().getOrDefault(locale,
                caseNames().getOrDefault(Locale.ENGLISH, getClass().getSimpleName()));
    }
}