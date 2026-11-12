package com.zhuzz.design.lab;

import com.zhuzz.design.lab.i18n.I18nMessages;

import java.io.File;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 通过扫描案例根包自动发现所有 DemoCase 实现，并按分类、模式名分组。
 * 新增案例只需新建类实现 DemoCase，无需注册文件。
 * Auto-discovers all DemoCase implementations and groups them by category and pattern.
 */
public class DemoRegistry {

    /** 案例根包：类放在该包（或子包）下即被自动发现 | Root package for auto-discovery */
    private static final String BASE_PACKAGE = "com.zhuzz.design.patternz";

    public static final LinkedHashMap<I18nMessages, LinkedHashMap<I18nMessages, List<DemoCase>>> registry = new LinkedHashMap<>();

    static {
        List<DemoCase> demos = new ArrayList<>();
        scanPackage(BASE_PACKAGE, demos);

        // 按枚举声明顺序排序（GOF 经典顺序：创建型 → 结构型 → 行为型）
        // Sort by enum ordinal (GoF order: creational → structural → behavioral)
        demos.sort(Comparator
                .comparing((DemoCase d) -> d.category().ordinal())
                .thenComparing(d -> d.pattern().ordinal()));

        for (DemoCase demo : demos) {
            registry
                    .computeIfAbsent(demo.category(), k -> new LinkedHashMap<>())
                    .computeIfAbsent(demo.pattern(), k -> new ArrayList<>())
                    .add(demo);
        }
    }

    private static void scanPackage(String packageName, List<DemoCase> out) {
        String path = packageName.replace('.', '/');
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        try {
            Enumeration<URL> resources = cl.getResources(path);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                if ("file".equals(url.getProtocol())) {
                    scanDir(new File(url.toURI()), packageName, out);
                }
                // 打包成 jar 运行时需在此扩展 jar 协议 | Extend here for jar protocol if needed
            }
        } catch (Exception e) {
            throw new IllegalStateException("扫描案例包失败: " + packageName, e);
        }
    }

    private static void scanDir(File dir, String packageName, List<DemoCase> out) {
        File[] files = dir.listFiles();
        if (files == null) return;
        for (File file : files) {
            if (file.isDirectory()) {
                scanDir(file, packageName + "." + file.getName(), out);
            } else if (file.getName().endsWith(".class") && !file.getName().contains("$")) {
                String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
                registerIfDemo(className, out);
            }
        }
    }

    private static void registerIfDemo(String className, List<DemoCase> out) {
        try {
            Class<?> type = Class.forName(className, false, Thread.currentThread().getContextClassLoader());
            if (DemoCase.class.isAssignableFrom(type)
                    && !type.isInterface()
                    && !Modifier.isAbstract(type.getModifiers())) {
                out.add((DemoCase) type.getDeclaredConstructor().newInstance());
            }
        } catch (Exception | LinkageError ignored) {
            // 跳过无法加载/实例化的类，避免影响整体发现 | Skip classes that cannot be instantiated
        }
    }

    public static int getTotalCases() {
        return registry.values().stream()
                .flatMap(m -> m.values().stream())
                .mapToInt(List::size)
                .sum();
    }
}