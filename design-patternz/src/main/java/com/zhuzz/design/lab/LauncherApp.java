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

public class LauncherApp extends JFrame {

    private JTree tree;
    private JTextArea outputArea;
    private JLabel statusBar;
    private JComboBox<String> langCombo;
    private JButton runBtn;
    private JButton clearBtn;
    private JLabel outputLabel;
    private JLabel titleLabel;
    private boolean suppressingLangEvent;

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
            runBtn.setEnabled(node != null && leafRunners.containsKey(node));
        });
        JScrollPane treeScroll = new JScrollPane(tree);
        treeScroll.setPreferredSize(new Dimension(240, 0));
        leftPanel.add(treeScroll, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        outputLabel = new JLabel("=== " + I18n.get(OUTPUT_TITLE) + " ===");
        outputLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
        rightPanel.add(outputLabel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        rightPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

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
        outputLabel.setText("=== " + I18n.get(OUTPUT_TITLE) + " ===");
        statusBar.setText(statusCountText());
        rebuildTree();
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