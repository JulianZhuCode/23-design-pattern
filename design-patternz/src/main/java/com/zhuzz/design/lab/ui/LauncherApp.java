package com.zhuzz.design.lab.ui;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.DemoRegistry;
import com.zhuzz.design.lab.OutputCapture;
import com.zhuzz.design.lab.ReadmeRenderer;
import com.zhuzz.design.lab.i18n.I18n;
import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.playground.PlaygroundCase;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.BTN_CLEAR;
import static com.zhuzz.design.lab.i18n.I18nMessages.BTN_RUN;
import static com.zhuzz.design.lab.i18n.I18nMessages.OUTPUT_TITLE;
import static com.zhuzz.design.lab.i18n.I18nMessages.STATUS_COUNT;
import static com.zhuzz.design.lab.i18n.I18nMessages.STATUS_READY;
import static com.zhuzz.design.lab.i18n.I18nMessages.TAB_README;
import static com.zhuzz.design.lab.i18n.I18nMessages.WINDOW_TITLE;

/**
 * Swing 图形界面入口：左侧案例树 + 右侧 README/输出区，
 * 后台线程运行案例并捕获输出，同时联动 i18n 语言切换。
 * Swing GUI entry: case tree on the left and README/output on the right,
 * runs cases on a background thread and reacts to language switches.
 */
public class LauncherApp extends JFrame {

    private CaseTreePanel caseTreePanel;
    private JTextArea outputArea;
    private JLabel statusBar;
    private JComboBox<String> langCombo;
    private JButton runBtn;
    private JButton clearBtn;
    private JLabel outputLabel;
    private JLabel readmeLabel;
    private ReadmeView readmeView;
    private PlaygroundPanel playgroundPanel;
    private JLabel titleLabel;
    // 重建语言下拉框时抑制事件，避免触发语言切换监听器造成重复刷新
    // Guard flag: suppress combo events while rebuilding the language selector
    private boolean suppressingLangEvent;

    public LauncherApp() {
        setTitle(I18n.get(WINDOW_TITLE));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(700, 400));

        initComponents();
        caseTreePanel.rebuild();

        I18n.onSwitch(this::onLanguageChanged);
    }

    private void initComponents() {
        add(buildHeader(), BorderLayout.NORTH);

        caseTreePanel = new CaseTreePanel(this::onCaseSelected, this::onPatternSelected);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buildLeftPanel(), buildRightPanel());
        splitPane.setDividerLocation(260);
        add(splitPane, BorderLayout.CENTER);

        statusBar = new JLabel(statusCountText());
        statusBar.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        add(statusBar, BorderLayout.SOUTH);

        runBtn.setEnabled(false);
        runBtn.addActionListener(e -> runSelected());
        clearBtn.addActionListener(e -> outputArea.setText(""));
    }

    // 顶部：标题 + 语言下拉框
    // Header: title + language selector
    private JPanel buildHeader() {
        JPanel header = new JPanel(new BorderLayout());
        titleLabel = new JLabel(I18n.get(WINDOW_TITLE));
        titleLabel.setFont(new Font(null, Font.BOLD, 14));
        header.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
        header.add(titleLabel, BorderLayout.WEST);

        langCombo = new JComboBox<>();
        for (String lang : I18n.getAvailableLanguages()) {
            langCombo.addItem(lang);
        }
        langCombo.setSelectedItem(I18n.getCurrentLanguageName());
        langCombo.addActionListener(e -> {
            if (suppressingLangEvent) return;
            I18n.switchTo(langCombo.getSelectedIndex());
        });
        header.add(langCombo, BorderLayout.EAST);
        return header;
    }

    // 左侧：案例树（纯导航）
    // Left: case tree (navigation only)
    private JPanel buildLeftPanel() {
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(caseTreePanel, BorderLayout.CENTER);
        return leftPanel;
    }

    // 右侧：README 展示区（上）+ 底部（左：运行/参数控制区 + 右：输出展示区）
    // Right: README display area (top) + bottom (left: run/param controls + right: output)
    private JPanel buildRightPanel() {
        JPanel rightPanel = new JPanel(new BorderLayout());

        // README 展示区（上），用 JavaFX WebView 承载以便 mermaid.js 渲染图表
        // README display area (top), hosted in JavaFX WebView for mermaid.js rendering
        JPanel readmePanel = new JPanel(new BorderLayout());
        readmeLabel = new JLabel("=== " + I18n.get(TAB_README) + " ===");
        readmeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
        readmePanel.add(readmeLabel, BorderLayout.NORTH);
        readmeView = new ReadmeView();
        readmePanel.add(readmeView, BorderLayout.CENTER);

        // 底部左侧：运行按钮 + 参数沙盒面板
        // Bottom-left: run button + playground panel
        JPanel controlPanel = new JPanel(new BorderLayout());
        JPanel runPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 4));
        runBtn = new JButton(I18n.get(BTN_RUN));
        runPanel.add(runBtn);
        playgroundPanel = new PlaygroundPanel();
        controlPanel.add(runPanel, BorderLayout.NORTH);
        controlPanel.add(playgroundPanel, BorderLayout.CENTER);

        // 底部右侧：输出展示区
        // Bottom-right: output display area
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputLabel = new JLabel("=== " + I18n.get(OUTPUT_TITLE) + " ===");
        // 清空按钮放到输出标题栏右侧，紧邻它作用的输出窗口
        // Clear button sits beside the output header, close to the area it affects
        clearBtn = new JButton(I18n.get(BTN_CLEAR));
        JPanel outputHeader = new JPanel(new BorderLayout());
        outputHeader.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
        outputHeader.add(outputLabel, BorderLayout.WEST);
        outputHeader.add(clearBtn, BorderLayout.EAST);
        outputPanel.add(outputHeader, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // 底部横向分割：控制区在左、输出区在右
        // Bottom horizontal split: controls on the left, output on the right
        JSplitPane bottomSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, controlPanel, outputPanel);
        bottomSplit.setResizeWeight(0.0);
        bottomSplit.setDividerLocation(220);

        JSplitPane verticalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, readmePanel, bottomSplit);
        verticalSplit.setResizeWeight(0.6);
        verticalSplit.setDividerLocation(360);
        rightPanel.add(verticalSplit, BorderLayout.CENTER);
        return rightPanel;
    }

    // 选中案例变化：联动运行按钮可用态与 README 展示
    // Case selection changed: sync the run button state and README display
    private void onCaseSelected(DemoCase demo) {
        runBtn.setEnabled(demo != null);
        playgroundPanel.showFor(demo instanceof PlaygroundCase pc ? pc : null);
        if (demo != null) {
            showReadme(demo);
        }
    }

    // 选中模式变化：展示该模式包根目录的模式级 README
    // Pattern selection changed: show the pattern-level README in the pattern's root package
    private void onPatternSelected(I18nMessages pattern) {
        if (pattern == null) return;
        readmeView.showHtml(ReadmeRenderer.renderPattern(pattern, I18n.getCurrentLocale()));
    }

    private void runSelected() {
        DemoCase demo = caseTreePanel.getSelectedCase();
        if (demo == null) return;

        runBtn.setEnabled(false);
        statusBar.setText(" " + I18n.get(STATUS_READY));

        // 组装运行动作：PlaygroundCase 用用户选定的参数运行，其余用默认无参运行
        // Build the run action: PlaygroundCase runs with collected values, others use run()
        Runnable action;
        if (demo instanceof PlaygroundCase playground) {
            Map<String, String> values = playgroundPanel.collectValues();
            action = () -> playground.run(values);
        } else {
            action = demo::run;
        }

        // 在后台线程运行案例，UI 更新切回 EDT（Swing 事件分发线程）
        // Run on a background thread; UI updates are marshalled back to the EDT
        new Thread(() -> {
            String output;
            try {
                output = OutputCapture.capture(action);
            } catch (Exception t) {
                StringWriter sw = new StringWriter();
                t.printStackTrace(new PrintWriter(sw));
                output = sw.toString();
            }
            String result = output;
            SwingUtilities.invokeLater(() -> {
                outputArea.setText(result);
                runBtn.setEnabled(true);
                statusBar.setText(statusCountText());
            });
        }).start();
    }

    // 渲染并展示当前案例的 README；缺失时清空
    // Render and display the selected case's README; clears when absent
    private void showReadme(DemoCase demo) {
        String html = ReadmeRenderer.render(demo, I18n.getCurrentLocale());
        readmeView.showHtml(html);
    }

    private String statusCountText() {
        return " " + String.format(I18n.get(STATUS_COUNT), DemoRegistry.getTotalCases());
    }

    private void onLanguageChanged() {
        rebuildLangCombo();
        refreshLocaleTexts();
        // 重建树会触发选中回调，从而用新语言刷新 README
        // Rebuilding the tree fires the selection callback, refreshing the README in the new locale
        caseTreePanel.rebuild();
    }

    private void rebuildLangCombo() {
        suppressingLangEvent = true;
        langCombo.removeAllItems();
        for (String lang : I18n.getAvailableLanguages()) {
            langCombo.addItem(lang);
        }
        langCombo.setSelectedItem(I18n.getCurrentLanguageName());
        suppressingLangEvent = false;
    }

    // 集中刷新所有依赖当前语言的静态文案
    // Refreshes all static texts that depend on the current locale in one place
    private void refreshLocaleTexts() {
        setTitle(I18n.get(WINDOW_TITLE));
        titleLabel.setText(I18n.get(WINDOW_TITLE));
        runBtn.setText(I18n.get(BTN_RUN));
        clearBtn.setText(I18n.get(BTN_CLEAR));
        readmeLabel.setText("=== " + I18n.get(TAB_README) + " ===");
        outputLabel.setText("=== " + I18n.get(OUTPUT_TITLE) + " ===");
        playgroundPanel.refreshTexts();
        statusBar.setText(statusCountText());
    }
}