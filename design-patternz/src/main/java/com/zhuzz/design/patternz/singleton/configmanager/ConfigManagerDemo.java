package com.zhuzz.design.patternz.singleton.configmanager;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ConfigManagerDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_SINGLETON; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Global Config", Locale.SIMPLIFIED_CHINESE, "全局配置");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        // 两次获取实例，验证是同一个对象
        // Fetch twice to verify the same instance
        ConfigManager first = ConfigManager.getInstance();
        ConfigManager second = ConfigManager.getInstance();
        System.out.println("Same instance: " + (first == second));

        // 读取默认配置
        // Read default config
        System.out.println("app.name = " + first.get("app.name"));

        // 修改配置后从另一处读取，验证全局共享
        // Update then read from the other reference to verify shared state
        first.set("app.theme", "dark");
        System.out.println("app.theme = " + second.get("app.theme"));

        // 打印全部配置
        // Print all entries
        first.printAll();
    }
}