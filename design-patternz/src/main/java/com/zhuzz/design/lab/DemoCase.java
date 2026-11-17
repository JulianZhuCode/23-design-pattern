package com.zhuzz.design.lab;

import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

/**
 * 设计模式案例的基础契约：声明案例的分类、多语言显示名与运行入口。
 * 案例通过扫描案例根包自动发现；本接口是注册表使用的公共类型，也是
 * PlaygroundCase 的父接口（现有案例均实现 PlaygroundCase），无参 run() 兼容最简案例。
 * Base contract for demo cases: declares category, localized names and the run entry.
 * Cases are auto-discovered by scanning the root package; it is the common type used by
 * the registry and the parent of PlaygroundCase (all current cases implement it), while
 * the no-arg run() supports the simplest, parameterless cases.
 */
public interface DemoCase {

    I18nMessages pattern();

    /**
     * 所属分类，由 pattern() 推导
     * Category derived from pattern()
     */
    default I18nMessages category() {
        return pattern().category();
    }

    /**
     * 显示名多语言映射：key 为语言，value 为显示值
     * Localized display names
     */
    Map<Locale, String> caseNames();

    void run();

    /**
     * 按语言取显示名，回退链：指定语言 → 英文 → 类名
     * Resolve name with fallback
     */
    default String caseName(Locale locale) {
        return caseNames().getOrDefault(locale,
                caseNames().getOrDefault(Locale.ENGLISH, getClass().getSimpleName()));
    }
}