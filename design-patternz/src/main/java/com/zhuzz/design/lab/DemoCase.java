package com.zhuzz.design.lab;

import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

/**
 * 每个设计模式案例通过实现本接口来声明自己的注册信息。
 * 案例通过扫描案例根包（com.zhuzz.design.patternz）自动发现，无需注册文件。
 * 案例显示名由各案例在 caseNames() 中自声明（多语言）。
 */
public interface DemoCase {

    I18nMessages pattern();

    /** 案例所属分类，由 pattern() 推导，无需单独配置 */
    default I18nMessages category() {
        return pattern().category();
    }

    /** 案例显示名的多语言映射：key 为语言，value 为显示值 */
    Map<Locale, String> caseNames();

    void run();

    /** 按语言取显示名，回退链：指定语言 → 英文 → 类名 */
    default String caseName(Locale locale) {
        return caseNames().getOrDefault(locale,
                caseNames().getOrDefault(Locale.ENGLISH, getClass().getSimpleName()));
    }
}