package com.zhuzz.design.lab;

import com.zhuzz.design.lab.i18n.I18nMessages;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

/**
 * 通过扫描案例根包自动发现所有 DemoCase 实现，并按分类、模式名分组。
 * 新增案例只需新建类实现 DemoCase，无需注册文件。
 * Auto-discovers all DemoCase implementations and groups them by category and pattern.
 */
public class DemoRegistry {

    /**
     * 案例根包：类放在该包（或子包）下即被自动发现
     * Root package for auto-discovery
     */
    private static final String BASE_PACKAGE = "com.zhuzz.design.patternz";

    /**
     * 反射扫描失败时记录警告，避免案例静默消失
     * Logger for reflective-scan failures, to avoid cases disappearing silently
     */
    private static final Logger LOGGER = Logger.getLogger(DemoRegistry.class.getName());

    /**
     * 案例注册表结构：分类 → (模式 → 案例列表)。
     * Registry structure: category → (pattern → list of cases).
     */
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
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    scanDir(new File(url.toURI()), packageName, out);
                } else if ("jar".equals(protocol)) {
                    // 打包成 jar 运行时按 jar 协议扫描条目
                    // Scan jar entries when running from a packaged jar
                    scanJar(url, path, out);
                }
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
                // 仅处理 .class，并跳过内部类（名称含 $），内部类不可能实现 DemoCase
                // Only .class files; skip inner classes (names containing $), which cannot be DemoCase
                String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
                registerIfDemo(className, out);
            }
        }
    }

    /**
     * 扫描 jar 包内指定目录下的 .class 条目，跳过内部类（名称含 $）。
     * Scans .class entries under the given path inside a jar, skipping inner classes.
     */
    private static void scanJar(URL url, String packagePath, List<DemoCase> out) throws IOException {
        URLConnection connection = url.openConnection();
        if (!(connection instanceof JarURLConnection jarConnection)) {
            LOGGER.warning("非 JarURLConnection，跳过 jar 扫描 Skip jar scan, not a JarURLConnection: " + url);
            return;
        }
        try (JarFile jarFile = jarConnection.getJarFile()) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String name = entry.getName();
                if (name.startsWith(packagePath + '/') && name.endsWith(".class") && !name.contains("$")) {
                    // 将条目路径转为类全名：com/zhuzz/.../XxxDemo.class → com.zhuzz....XxxDemo
                    // Convert entry path to FQCN: com/zhuzz/.../XxxDemo.class → com.zhuzz....XxxDemo
                    String className = name.substring(0, name.length() - 6).replace('/', '.');
                    registerIfDemo(className, out);
                }
            }
        }
    }

    private static void registerIfDemo(String className, List<DemoCase> out) {
        try {
            Class<?> type = Class.forName(className, false, Thread.currentThread().getContextClassLoader());
            if (DemoCase.class.isAssignableFrom(type)
                    && !type.isInterface()
                    && !Modifier.isAbstract(type.getModifiers())) {
                // 通过公开无参构造实例化，DemoCase 实现类必须保留无参构造
                // Instantiate via the public no-arg constructor (required for DemoCase implementations)
                out.add((DemoCase) type.getDeclaredConstructor().newInstance());
            }
        } catch (Exception | LinkageError e) {
            // 记录无法加载/实例化的类，便于定位案例消失问题
            // Log classes that cannot be loaded or instantiated
            LOGGER.warning("跳过无法实例化的案例类 Skip case class that cannot be instantiated: " + className + " — " + e);
        }
    }

    public static int getTotalCases() {
        return registry.values().stream()
                .flatMap(m -> m.values().stream())
                .mapToInt(List::size)
                .sum();
    }
}