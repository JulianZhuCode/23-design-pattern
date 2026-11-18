package com.zhuzz.design.patternz.singleton.innerclasssingleton;

import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class InnerClassSingletonDemo extends DemoSupport {
    @Override public I18nMessages pattern() { return PAT_SINGLETON; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Static Inner Class", Locale.SIMPLIFIED_CHINESE, "静态内部类");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        // 获取单例实例
        // Get the singleton instance
        InnerClassSingleton singleton = InnerClassSingleton.getInstance();

        // 调用成员方法
        // Call a member method
        singleton.showMessage();
    }
}