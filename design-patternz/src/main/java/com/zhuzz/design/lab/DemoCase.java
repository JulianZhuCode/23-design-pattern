package com.zhuzz.design.lab;

import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;

/**
 * 每个设计模式案例通过实现本接口来声明自己的注册信息，
 * 并通过 META-INF/services 自动发现，无需集中注册。
 * 案例显示名由各案例自己包内的 messages 资源文件维护（见 BaseDemoCase）。
 */
public interface DemoCase {

    I18nMessages category();

    I18nMessages pattern();

    String caseName(Locale locale);

    void run();
}