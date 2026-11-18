package com.zhuzz.design.lab;

import com.zhuzz.design.lab.i18n.I18nMessages;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * DemoRegistry 的单元测试：验证案例自动发现、分类归属与命名契约。
 * Unit tests for DemoRegistry: verify auto-discovery, category mapping and naming contract.
 */
class DemoRegistryTest {

    /**
     * 自动发现应覆盖全部 23 种 GoF 模式（PAT_* 常量）。
     * Auto-discovery must cover all 23 GoF patterns (the PAT_* constants).
     */
    @Test
    void discoversAllTwentyThreePatterns() {
        Set<I18nMessages> expected = Arrays.stream(I18nMessages.values())
                .filter(p -> p.category() != null)
                .collect(Collectors.toSet());

        Set<I18nMessages> discovered = DemoRegistry.registry.values().stream()
                .flatMap(m -> m.keySet().stream())
                .collect(Collectors.toSet());

        assertEquals(expected, discovered);
    }

    /**
     * 每个案例都应归入其声明的分类与模式。
     * Every case must sit under its declared category and pattern.
     */
    @Test
    void groupsEveryCaseUnderItsDeclaredCategoryAndPattern() {
        for (var catEntry : DemoRegistry.registry.entrySet()) {
            I18nMessages category = catEntry.getKey();
            for (var patEntry : catEntry.getValue().entrySet()) {
                assertEquals(category, patEntry.getKey().category());
                for (DemoCase demo : patEntry.getValue()) {
                    assertEquals(patEntry.getKey(), demo.pattern());
                    assertEquals(category, demo.category());
                }
            }
        }
    }

    /**
     * 每个案例都应提供非空、非空白的英文显示名。
     * Every case must expose a non-blank English display name.
     */
    @Test
    void everyCaseHasNonNullEnglishName() {
        for (DemoCase demo : allCases()) {
            assertNotNull(demo.pattern());
            String name = demo.caseName(Locale.ENGLISH);
            assertNotNull(name);
            assertFalse(name.isBlank());
        }
    }

    /**
     * 注册表内不应出现重复案例类。
     * The registry must not contain duplicate case classes.
     */
    @Test
    void containsNoDuplicateCases() {
        Set<Class<?>> classes = new HashSet<>();
        for (DemoCase demo : allCases()) {
            assertTrue(classes.add(demo.getClass()), "重复案例 Duplicate case: " + demo.getClass());
        }
    }

    /**
     * 案例总数应大于零，且与注册表结构统计一致。
     * The total case count must be positive and consistent with the registry structure.
     */
    @Test
    void totalCountMatchesRegistry() {
        int counted = DemoRegistry.registry.values().stream()
                .flatMap(m -> m.values().stream())
                .mapToInt(List::size)
                .sum();
        assertEquals(counted, DemoRegistry.getTotalCases());
        assertTrue(counted > 0);
    }

    private static List<DemoCase> allCases() {
        return DemoRegistry.registry.values().stream()
                .flatMap(m -> m.values().stream())
                .flatMap(List::stream)
                .toList();
    }
}