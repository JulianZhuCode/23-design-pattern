package com.zhuzz.design.lab;

import com.zhuzz.design.patternz.abstractfactory.officesuite.OfficeSuiteDemo;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ReadmeRenderer 的单元测试：验证 README 资源加载与 HTML 渲染。
 * Unit tests for ReadmeRenderer: verify README resource loading and HTML rendering.
 */
class ReadmeRendererTest {

    /**
     * 英文 README 应被渲染为非空 HTML 页面。
     * The English README must render as a non-null HTML page.
     */
    @Test
    void rendersEnglishReadme() {
        String html = ReadmeRenderer.render(new OfficeSuiteDemo(), Locale.ENGLISH);
        assertNotNull(html);
        assertTrue(html.contains("<html"));
    }

    /**
     * 中文 README 应被渲染为非空 HTML 页面。
     * The Chinese README must render as a non-null HTML page.
     */
    @Test
    void rendersChineseReadme() {
        String html = ReadmeRenderer.render(new OfficeSuiteDemo(), Locale.SIMPLIFIED_CHINESE);
        assertNotNull(html);
        assertTrue(html.contains("<html"));
    }
}