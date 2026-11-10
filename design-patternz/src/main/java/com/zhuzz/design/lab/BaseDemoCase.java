package com.zhuzz.design.lab;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 案例基类：案例显示名由案例自身所在包内的 messages 资源文件维护，
 * key 为 Demo 类的简单类名（如 DecoratorDemo=咖啡加料）。
 * 新增案例只需在包内提供 messages_zh.properties / messages_en.properties。
 * 资源缺失或 key 未命中时回退为类名，避免影响树渲染。
 */
public abstract class BaseDemoCase implements DemoCase {

    @Override
    public String caseName(Locale locale) {
        String key = getClass().getSimpleName();
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(getClass().getPackageName() + ".messages", locale);
            return bundle.containsKey(key) ? bundle.getString(key) : key;
        } catch (MissingResourceException e) {
            return key;
        }
    }
}