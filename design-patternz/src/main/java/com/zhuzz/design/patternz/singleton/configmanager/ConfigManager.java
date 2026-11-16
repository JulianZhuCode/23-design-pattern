package com.zhuzz.design.patternz.singleton.configmanager;

import java.util.LinkedHashMap;
import java.util.Map;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 单例：全局配置管理器
 * 应用启动时加载默认配置，全局共享唯一实例，避免多处重复加载与配置不一致。
 * Singleton: global configuration manager
 * Loads default config at startup; a single shared instance avoids repeated loading and inconsistency.
 */
public class ConfigManager {

    /**
     * 配置键值存储
     * Key-value config storage
     */
    private final Map<String, String> configs = new LinkedHashMap<>();

    /**
     * 私有构造：加载默认配置
     * Private ctor: loads default config
     */
    private ConfigManager() {
        loadDefaults();
    }

    /**
     * 获取全局唯一实例
     * Get the single global instance
     */
    public static ConfigManager getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 读取配置项
     * Read a config entry
     */
    public String get(String key) {
        return configs.get(key);
    }

    /**
     * 设置配置项
     * Set a config entry
     */
    public void set(String key, String value) {
        configs.put(key, value);
    }

    /**
     * 打印全部配置
     * Print all config entries
     */
    public void printAll() {
        configs.forEach((key, value) -> Messages.println("config.entry", key, value));
    }

    /**
     * 加载默认配置
     * Load default config
     */
    private void loadDefaults() {
        configs.put("app.name", "Design Pattern Lab");
        configs.put("app.version", "1.0.0");
        configs.put("app.locale", "zh_CN");
    }

    /**
     * 静态内部类持有唯一实例，类加载保证线程安全并实现懒加载
     * Holder owns the instance; class loading guarantees thread safety + lazy init
     */
    private static class Holder {
        static final ConfigManager INSTANCE = new ConfigManager();
    }
}