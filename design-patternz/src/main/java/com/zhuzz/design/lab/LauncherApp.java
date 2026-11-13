package com.zhuzz.design.lab;

import com.zhuzz.design.lab.i18n.I18n;
import com.zhuzz.design.lab.i18n.I18nMessages;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * Swing 图形界面入口：以树形展示所有案例（分类 → 模式 → 案例），
 * 后台线程运行案例并捕获输出，同时联动 i18n 语言切换。
 * Swing GUI entry: tree of cases (category → pattern → case),
 * runs cases on a background thread and reacts to language switches.
 */
public class LauncherApp extends JFrame {

    private JTree tree;
    private JTextArea outputArea;
    private JLabel statusBar;
    private JComboBox<String> langCombo;
    private JButton runBtn;
    private JButton clearBtn;
    private JLabel outputLabel;
    private JLabel readmeLabel;
    private ReadmeView readmeView;
    private JLabel titleLabel;
    // 重建语言下拉框时抑制事件，避免触发语言切换监听器造成重复刷新
    // Guard flag: suppress combo events while rebuilding the language selector
    private boolean suppressingLangEvent;

    // 叶节点（案例）到运行动作的映射；运行按钮据此判断选中节点是否可运行
    // Maps leaf nodes (cases) to their run actions
    private final Map<DefaultMutableTreeNode, Runnable> leafRunners = new HashMap<>();

    public LauncherApp() {
        setTitle("🧩 " + I18n.get(WINDOW_TITLE));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(700, 400));

        initComponents();
        rebuildTree();

        I18n.onSwitch(this::onLanguageChanged);
    }

    private void initComponents() {
        JPanel header = new JPanel(new BorderLayout());
        titleLabel = new JLabel("🧩 " + I18n.get(WINDOW_TITLE));
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
        add(header, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel(new BorderLayout());

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 4));
        runBtn = new JButton(I18n.get(BTN_RUN));
        clearBtn = new JButton(I18n.get(BTN_CLEAR));
        btnPanel.add(runBtn);
        btnPanel.add(clearBtn);
        leftPanel.add(btnPanel, BorderLayout.NORTH);

        DefaultMutableTreeNode placeholder = new DefaultMutableTreeNode();
        tree = new JTree(placeholder);
        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
        tree.setCellRenderer(new I18nRenderer());
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            boolean isLeaf = node != null && leafRunners.containsKey(node);
            runBtn.setEnabled(isLeaf);
            if (isLeaf) {
                showReadme((DemoCase) node.getUserObject());
            }
        });
        JScrollPane treeScroll = new JScrollPane(tree);
        treeScroll.setPreferredSize(new Dimension(240, 0));
        leftPanel.add(treeScroll, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());

        // README 展示区（上），渲染 Markdown 为 HTML
        // README display area (top), Markdown rendered as HTML
        JPanel readmePanel = new JPanel(new BorderLayout());
        readmeLabel = new JLabel("=== " + I18n.get(TAB_README) + " ===");
        readmeLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
        readmePanel.add(readmeLabel, BorderLayout.NORTH);
        // 用 JavaFX WebView 承载 README，以便 mermaid.js 渲染出真正的图表
        // Host README in a JavaFX WebView so mermaid.js can render real diagrams
        readmeView = new ReadmeView();
        readmePanel.add(readmeView, BorderLayout.CENTER);

        // 输出展示区（下）
        // Output display area (bottom)
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputLabel = new JLabel("=== " + I18n.get(OUTPUT_TITLE) + " ===");
        outputLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
        outputPanel.add(outputLabel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JSplitPane verticalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, readmePanel, outputPanel);
        verticalSplit.setResizeWeight(0.6);
        verticalSplit.setDividerLocation(360);
        rightPanel.add(verticalSplit, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(260);
        add(splitPane, BorderLayout.CENTER);

        statusBar = new JLabel(statusCountText());
        statusBar.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        add(statusBar, BorderLayout.SOUTH);

        runBtn.setEnabled(false);
        runBtn.addActionListener(e -> runSelected());
        clearBtn.addActionListener(e -> outputArea.setText(""));
    }

    private void runSelected() {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        Runnable runner = leafRunners.get(node);
        if (runner == null) return;

        runBtn.setEnabled(false);
        statusBar.setText(" " + I18n.get(STATUS_READY));

        // 在后台线程运行案例，UI 更新切回 EDT（Swing 事件分发线程）
        // Run on a background thread; UI updates are marshalled back to the EDT
        new Thread(() -> {
            String output;
            try {
                output = OutputCapture.capture(runner);
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

    private void rebuildTree() {
        String selectedPath = saveSelectedPath();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        leafRunners.clear();

        for (var catEntry : DemoRegistry.registry.entrySet()) {
            DefaultMutableTreeNode catNode = new DefaultMutableTreeNode(catEntry.getKey());
            for (var patEntry : catEntry.getValue().entrySet()) {
                DefaultMutableTreeNode patNode = new DefaultMutableTreeNode(patEntry.getKey());
                for (DemoCase item : patEntry.getValue()) {
                    DefaultMutableTreeNode caseNode = new DefaultMutableTreeNode(item);
                    patNode.add(caseNode);
                    leafRunners.put(caseNode, item::run);
                }
                catNode.add(patNode);
            }
            root.add(catNode);
        }

        tree.setModel(new DefaultTreeModel(root));

        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }

        restoreSelectedPath(selectedPath);
    }

    // 记录当前选中案例的路径，用于语言切换重建树后恢复选中
    // Records the selected case path so it can be restored after a rebuild
    private String saveSelectedPath() {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null) return null;
        if (leafRunners.containsKey(node)) {
            return buildNodePath(node);
        }
        return null;
    }

    private String buildNodePath(DefaultMutableTreeNode node) {
        StringBuilder sb = new StringBuilder();
        for (Object o : node.getUserObjectPath()) {
            if (o instanceof I18nMessages) {
                if (!sb.isEmpty()) sb.append("/");
                sb.append(((I18nMessages) o).name());
            } else if (o instanceof DemoCase) {
                if (!sb.isEmpty()) sb.append("/");
                sb.append(o.getClass().getName());
            }
        }
        return sb.toString();
    }

    // 按路径恢复之前选中的案例节点
    // Restores the previously selected case node by path
    private void restoreSelectedPath(String path) {
        if (path == null) return;
        for (var entry : leafRunners.entrySet()) {
            if (buildNodePath(entry.getKey()).equals(path)) {
                tree.setSelectionPath(new javax.swing.tree.TreePath(entry.getKey().getPath()));
                return;
            }
        }
    }

    private void onLanguageChanged() {
        suppressingLangEvent = true;
        langCombo.removeAllItems();
        for (String lang : I18n.getAvailableLanguages()) {
            langCombo.addItem(lang);
        }
        langCombo.setSelectedItem(I18n.getCurrentLanguageName());
        suppressingLangEvent = false;

        setTitle("🧩 " + I18n.get(WINDOW_TITLE));
        titleLabel.setText("🧩 " + I18n.get(WINDOW_TITLE));
        runBtn.setText(I18n.get(BTN_RUN));
        clearBtn.setText(I18n.get(BTN_CLEAR));
        readmeLabel.setText("=== " + I18n.get(TAB_README) + " ===");
        outputLabel.setText("=== " + I18n.get(OUTPUT_TITLE) + " ===");
        statusBar.setText(statusCountText());
        rebuildTree();

        // 语言切换后刷新当前选中案例的 README
        // Refresh the README for the currently selected case after a language switch
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node != null && leafRunners.containsKey(node)) {
            showReadme((DemoCase) node.getUserObject());
        }
    }

    private static class I18nRenderer extends DefaultTreeCellRenderer {
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                      boolean sel, boolean expanded,
                                                      boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            Object userObject = node.getUserObject();
            if (userObject instanceof I18nMessages) {
                setText(I18n.get((I18nMessages) userObject));
            } else if (userObject instanceof DemoCase) {
                setText(((DemoCase) userObject).caseName(I18n.getCurrentLocale()));
            }
            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LauncherApp().setVisible(true));
    }
}