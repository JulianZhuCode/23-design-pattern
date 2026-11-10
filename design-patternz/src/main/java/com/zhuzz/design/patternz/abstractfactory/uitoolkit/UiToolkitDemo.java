package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class UiToolkitDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_ABSTRACT_FACTORY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "UI Toolkit", Locale.SIMPLIFIED_CHINESE, "跨平台 UI 组件");
    }
    @Override public void run() {
        UIFactory windowsFactory = new WindowsFactory();
        windowsFactory.createButton().click();
        windowsFactory.createTextField().input("Hello");

        System.out.println("----------");

        UIFactory macFactory = new MacFactory();
        macFactory.createButton().click();
        macFactory.createTextField().input("World");
    }
}