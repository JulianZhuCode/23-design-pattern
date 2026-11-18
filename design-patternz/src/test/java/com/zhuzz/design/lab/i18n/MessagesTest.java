package com.zhuzz.design.lab.i18n;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Messages 的单元测试：验证输出文案的 i18n 回退链（当前语言 → 英文 → key 本身）。
 * Unit tests for Messages: verify the i18n fallback chain (current locale → English → key).
 */
class MessagesTest {

    // 英文在 I18n 中注册于首位（index 0），中文注册于第二位（index 1）
    // English is registered first (index 0), Chinese second (index 1) in I18n
    private static final int ENGLISH = 0;
    private static final int CHINESE = 1;

    @AfterEach
    void restoreEnglish() {
        I18n.switchTo(ENGLISH);
    }

    /**
     * 当前语言为英文时，返回英文文案并填充占位符。
     * Returns English text with placeholders filled when the current locale is English.
     */
    @Test
    void resolvesEnglishWithPlaceholder() {
        I18n.switchTo(ENGLISH);
        assertEquals("Hello, World!", Messages.get("greeting", "World"));
    }

    /**
     * 当前语言为中文时，返回中文文案并填充占位符。
     * Returns Chinese text with placeholders filled when the current locale is Chinese.
     */
    @Test
    void resolvesChineseWithPlaceholder() {
        I18n.switchTo(CHINESE);
        assertEquals("你好，World！", Messages.get("greeting", "World"));
    }

    /**
     * 中文缺失某 key 时回退到英文。
     * Falls back to English when a key is missing in Chinese.
     */
    @Test
    void fallsBackToEnglishWhenChineseMissing() {
        I18n.switchTo(CHINESE);
        assertEquals("English only text", Messages.get("only_en"));
    }

    /**
     * 中英文都缺失某 key 时回退到 key 本身。
     * Falls back to the key itself when missing in both locales.
     */
    @Test
    void fallsBackToKeyWhenMissingEverywhere() {
        I18n.switchTo(ENGLISH);
        assertEquals("no.such.key", Messages.get("no.such.key"));
    }
}