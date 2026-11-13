package com.zhuzz.design.lab;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 读取案例所在包的 README 并渲染为完整 HTML 页面。
 * 与 GitHub 对齐：{@code ```mermaid} 代码块会被改写为 {@code <div class="mermaid">}，
 * 由打包在 classpath 中的 mermaid.js（离线）在浏览器内核里渲染成真实的流程图/类图。
 *
 * Loads a case's README (by locale) and renders it into a full HTML page.
 * GitHub-parity: {@code ```mermaid} fences are rewritten into {@code <div class="mermaid">}
 * and rendered into real diagrams by the bundled (offline) mermaid.js inside a browser engine.
 */
public final class ReadmeRenderer {

    private static final List<Extension> EXTENSIONS = List.of(TablesExtension.create());

    private static final Parser PARSER = Parser.builder().extensions(EXTENSIONS).build();
    private static final HtmlRenderer RENDERER = HtmlRenderer.builder().extensions(EXTENSIONS).build();

    // Mermaid 渲染脚本：打包在 classpath 中，离线即可渲染图表
    // Bundled Mermaid script: on the classpath, renders diagrams offline
    private static final String MERMAID_JS = loadResource("/mermaid/mermaid.min.js");

    // 页面骨架、样式与初始化脚本以独立 html/css/js 文件承载，Java 仅负责加载与拼装
    // Page skeleton, styles and init script live in standalone html/css/js files; Java only loads & assembles
    private static final String TEMPLATE = loadResource("/readme/template.html");
    private static final String CSS = loadResource("/readme/readme.css");
    private static final String INIT_JS = loadResource("/readme/mermaid-init.js");

    private ReadmeRenderer() {
    }

    /**
     * 按语言渲染 README 为 HTML；无 README 时返回 null。
     * Renders the README for the given locale; returns null if absent.
     */
    public static String render(DemoCase demo, Locale locale) {
        String markdown = load(demo, locale);
        if (markdown == null) return null;
        Node document = PARSER.parse(markdown);
        rewriteMermaidBlocks(document);
        return wrapHtml(RENDERER.render(document));
    }

    /**
     * 将 {@code ```mermaid} 代码块改写为 {@code <div class="mermaid">} 原始文本块，
     * 交由 mermaid.js 渲染成图；其余代码块保持不变。
     * Rewrites {@code ```mermaid} fences into raw {@code <div class="mermaid">} blocks for mermaid.js;
     * all other fences are left untouched.
     */
    private static void rewriteMermaidBlocks(Node document) {
        List<FencedCodeBlock> mermaidBlocks = new ArrayList<>();
        document.accept(new AbstractVisitor() {
            @Override
            public void visit(FencedCodeBlock block) {
                if ("mermaid".equalsIgnoreCase(block.getInfo())) {
                    mermaidBlocks.add(block);
                }
                visitChildren(block);
            }
        });
        for (FencedCodeBlock block : mermaidBlocks) {
            HtmlBlock html = new HtmlBlock();
            html.setLiteral("<div class=\"mermaid\">\n"
                    + escapeHtml(block.getLiteral())
                    + "</div>\n");
            // 在代码块后插入 HTML 块，再移除原代码块（0.23.0 无 replaceWith）
            // Insert the HTML block after the fence, then detach the fence (no replaceWith in 0.23.0)
            block.insertAfter(html);
            block.unlink();
        }
    }

    // 对 mermaid 源码做 HTML 转义，避免其标签文本被当作 HTML 解析
    // Escapes mermaid source so its labels are not parsed as HTML
    private static String escapeHtml(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    private static String load(DemoCase demo, Locale locale) {
        String pkg = demo.getClass().getPackageName().replace('.', '/');
        ClassLoader cl = demo.getClass().getClassLoader();
        // 中文优先 README_zh.md，回退 README.md
        // Prefer README_zh.md for Chinese, fall back to README.md
        if ("zh".equals(locale.getLanguage())) {
            String localized = read(cl, pkg + "/README_zh.md");
            if (localized != null) return localized;
        }
        return read(cl, pkg + "/README.md");
    }

    private static String read(ClassLoader cl, String path) {
        try (InputStream in = cl.getResourceAsStream(path)) {
            return in == null ? null : new String(in.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return null;
        }
    }

    private static String loadResource(String path) {
        try (InputStream in = ReadmeRenderer.class.getResourceAsStream(path)) {
            return in == null ? "" : new String(in.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    private static String wrapHtml(String body) {
        return TEMPLATE
                .replace("{{CSS}}", CSS)
                .replace("{{CONTENT}}", body)
                .replace("{{MERMAID_JS}}", MERMAID_JS)
                .replace("{{INIT_JS}}", INIT_JS);
    }
}