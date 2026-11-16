package com.zhuzz.design.lab.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 面向"案例运行输出"的本地化工具：按调用方所在包加载同目录下的 output_*.properties，
 * 用 MessageFormat 占位符格式化后返回/打印。
 * 回退链：当前语言 → 英文 → key 本身（漏翻时不崩溃、仍可读）。
 * Localization helper for demo runtime output: loads output_*.properties co-located
 * with the caller's package, formats MessageFormat placeholders, and returns/prints.
 * Fallback chain: current locale → English → the key itself.
 */
public final class Messages {

    /** 每个 demo 包内资源文件的基础名：output_en.properties / output_zh.properties。 */
    private static final String BUNDLE_NAME = "output";

    private static final Map<BundleKey, ResourceBundle> CACHE = new ConcurrentHashMap<>();

    private Messages() {
    }

    /**
     * 取当前语言下 key 对应文案并填充占位符。
     * Returns the localized text for key with placeholders filled in.
     */
    public static String get(String key, Object... args) {
        String pattern = resolve(key);
        return args.length == 0 ? pattern : MessageFormat.format(pattern, args);
    }

    /**
     * 取当前语言文案并打印到标准输出，语义等价于原有的 System.out.println。
     * Prints the localized text to stdout, semantically replacing System.out.println.
     */
    public static void println(String key, Object... args) {
        System.out.println(get(key, args));
    }

    /**
     * 取当前语言文案并打印到标准输出（不换行）。
     * Prints the localized text to stdout without a trailing newline.
     */
    public static void print(String key, Object... args) {
        System.out.print(get(key, args));
    }

    private static String resolve(String key) {
        Class<?> caller = callerClass();
        String packageName = caller.getPackageName();
        Locale locale = I18n.getCurrentLocale();

        ResourceBundle bundle = bundle(packageName, locale);
        if (bundle != null && bundle.containsKey(key)) {
            return bundle.getString(key);
        }
        ResourceBundle english = bundle(packageName, Locale.ENGLISH);
        if (english != null && english.containsKey(key)) {
            return english.getString(key);
        }
        return key;
    }

    private static ResourceBundle bundle(String packageName, Locale locale) {
        BundleKey cacheKey = new BundleKey(packageName, locale);
        ResourceBundle cached = CACHE.get(cacheKey);
        if (cached != null) {
            return cached;
        }
        ResourceBundle loaded = load(packageName, locale);
        if (loaded != null) {
            ResourceBundle existing = CACHE.putIfAbsent(cacheKey, loaded);
            return existing != null ? existing : loaded;
        }
        return null;
    }

    private static ResourceBundle load(String packageName, Locale locale) {
        try {
            String baseName = packageName + "." + BUNDLE_NAME;
            return ResourceBundle.getBundle(baseName, locale, Messages.class.getClassLoader());
        } catch (MissingResourceException e) {
            return null;
        }
    }

    /**
     * 通过 StackWalker 找到 Messages 之外的首个调用类，从而用其所在包定位资源文件。
     * Locates the first caller class outside Messages to derive its package for resource lookup.
     */
    private static Class<?> callerClass() {
        return StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                .walk(frames -> frames
                        .map(StackWalker.StackFrame::getDeclaringClass)
                        .filter(c -> c != Messages.class)
                        .findFirst()
                        .orElse(Messages.class));
    }

    private record BundleKey(String packageName, Locale locale) {
    }
}