package com.zhuzz.design.lab;

import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ServiceLoader;

/**
 * 通过 ServiceLoader 自动发现所有 DemoCase 实现，并按其声明的
 * 分类、模式名进行分组。新增案例无需改动本类。
 */
public class DemoRegistry {

    public static final LinkedHashMap<I18nMessages, LinkedHashMap<I18nMessages, List<DemoCase>>> registry = new LinkedHashMap<>();

    static {
        List<DemoCase> demos = new ArrayList<>();
        ServiceLoader.load(DemoCase.class).forEach(demos::add);

        // 按枚举声明顺序排序：category/pattern 的 ordinal 已在 I18nMessages 中
        // 按 GOF 经典顺序声明，因此分类顺序为 创建型 → 结构型 → 行为型，模式名保持经典顺序。
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

    public static int getTotalCases() {
        return registry.values().stream()
                .flatMap(m -> m.values().stream())
                .mapToInt(List::size)
                .sum();
    }
}