package com.zhuzz.design.lab.ui;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * 内嵌 JavaFX WebView 的 Swing 面板，用于渲染包含 Mermaid 图的 HTML 页面。
 * Swing 负责整体布局，WebView（WebKit）负责执行 mermaid.js 把图表画出来，
 * 从而在保持现有 Swing 架构的同时获得与 GitHub 一致的图表展示效果。
 *
 * A Swing panel embedding a JavaFX WebView, used to render HTML pages containing Mermaid diagrams.
 * Swing owns the layout while WebView (WebKit) runs mermaid.js to draw the diagrams,
 * keeping the existing Swing architecture while matching GitHub's rendering.
 */
public final class ReadmeView extends JFXPanel {

    private WebEngine engine;
    // JavaFX 场景尚未就绪前暂存待展示的 HTML，就绪后立即加载
    // Holds the pending HTML until the JavaFX scene is ready
    private String pendingHtml;

    public ReadmeView() {
        // 防止 JavaFX 工具包在 Swing 主窗口仍存活时提前结束 JVM
        // Prevent the JavaFX toolkit from terminating the JVM while the Swing window is alive
        Platform.setImplicitExit(false);
        Platform.runLater(() -> {
            WebView webView = new WebView();
            engine = webView.getEngine();
            setScene(new Scene(webView));
            if (pendingHtml != null) {
                engine.loadContent(pendingHtml);
                pendingHtml = null;
            }
        });
    }

    /**
     * 展示 HTML 内容；null 或空串则清空视图。
     * Displays the HTML content; null or blank clears the view.
     */
    public void showHtml(String html) {
        String content = (html == null) ? "<html><body></body></html>" : html;
        // WebEngine 只能在 JavaFX 应用线程上操作
        // WebEngine must be manipulated on the JavaFX application thread
        Platform.runLater(() -> {
            if (engine == null) {
                pendingHtml = content;
            } else {
                engine.loadContent(content);
            }
        });
    }
}