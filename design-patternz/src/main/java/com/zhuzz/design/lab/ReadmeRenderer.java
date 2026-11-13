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
        return "<html><head><meta charset=\"UTF-8\"><style>"
                + CSS
                + "</style></head><body>"
                + body
                + "<script>" + MERMAID_JS + "</script>"
                + "<script>mermaid.initialize({ startOnLoad: true, theme: 'default' });</script>"
                + "</body></html>";
    }

    // GitHub 风格的排版，使 README 展示效果与 GitHub 尽量一致
    // GitHub-like typography so the README looks close to GitHub
    private static final String CSS =
            "body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Helvetica, Arial, sans-serif; "
                    + "font-size: 15px; line-height: 1.6; color: #1f2328; padding: 16px 24px; }"
                    + "h1, h2, h3, h4 { font-weight: 600; line-height: 1.25; margin: 24px 0 16px; }"
                    + "h1 { font-size: 2em; padding-bottom: .3em; border-bottom: 1px solid #d0d7de; }"
                    + "h2 { font-size: 1.5em; padding-bottom: .3em; border-bottom: 1px solid #d0d7de; }"
                    + "h3 { font-size: 1.25em; }"
                    + "code { font-family: 'Consolas', 'Menlo', monospace; font-size: 85%; background: #eff1f3; "
                    + "padding: 2px 4px; border-radius: 4px; }"
                    + "pre { background: #f6f8fa; padding: 12px 16px; overflow: auto; border-radius: 6px; }"
                    + "pre code { background: transparent; padding: 0; }"
                    + "table { border-collapse: collapse; margin: 16px 0; }"
                    + "th, td { border: 1px solid #d0d7de; padding: 6px 12px; }"
                    + "th { background: #f6f8fa; }"
                    + "blockquote { border-left: 4px solid #d0d7de; margin: 16px 0; padding: 0 1em; color: #57606a; }"
                    + "img { max-width: 100%; }"
                    + "a { color: #0969da; text-decoration: none; }"
                    + "ul, ol { padding-left: 2em; }"
                    + ".mermaid { margin: 16px 0; text-align: center; }";
}