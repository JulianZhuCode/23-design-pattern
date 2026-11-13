package com.zhuzz.design.lab.ui;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.DemoRegistry;
import com.zhuzz.design.lab.i18n.I18nMessages;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 案例树面板：根据 DemoRegistry 构建分类 → 模式 → 案例 树，
 * 记住/恢复选中案例，并在选中变化时通过回调通知外部（用于联动运行按钮与 README）。
 * 语言切换后调用 {@link #rebuild()} 重建树。
 *
 * Case tree panel: builds the category → pattern → case tree from DemoRegistry,
 * persists/restores the selected case, and notifies the outside via callback on
 * selection change (to sync the run button and README). Call {@link #rebuild()} on locale switch.
 */
public class CaseTreePanel extends JPanel {

    private final JTree tree;
    private final Consumer<DemoCase> onCaseSelected;
    // 叶节点（案例）到运行动作的映射；据此判断选中节点是否可运行
    // Maps leaf nodes (cases) to their run actions
    private final Map<DefaultMutableTreeNode, Runnable> leafRunners = new HashMap<>();
    // 重建树时抑制选中事件，避免重建过程中触发多次回调
    // Suppresses selection events while rebuilding to avoid duplicate callbacks
    private boolean rebuilding;

    public CaseTreePanel(Consumer<DemoCase> onCaseSelected) {
        super(new BorderLayout());
        this.onCaseSelected = onCaseSelected;

        DefaultMutableTreeNode placeholder = new DefaultMutableTreeNode();
        tree = new JTree(placeholder);
        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
        tree.setCellRenderer(new I18nRenderer());
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(e -> {
            if (rebuilding) return;
            fireSelection();
        });

        JScrollPane treeScroll = new JScrollPane(tree);
        treeScroll.setPreferredSize(new Dimension(240, 0));
        add(treeScroll, BorderLayout.CENTER);
    }

    /**
     * 重建树，尽量恢复之前的选中案例，并通知外部当前选中状态。
     * Rebuilds the tree, restoring the previous selection when possible,
     * then notifies the outside of the current selection.
     */
    public void rebuild() {
        rebuilding = true;
        try {
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
        } finally {
            rebuilding = false;
        }
        fireSelection();
    }

    /**
     * 当前选中的案例；未选中或选中非案例节点时返回 null。
     * The currently selected case, or null when nothing / a non-case node is selected.
     */
    public DemoCase getSelectedCase() {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node != null && leafRunners.containsKey(node)) {
            return (DemoCase) node.getUserObject();
        }
        return null;
    }

    private void fireSelection() {
        if (onCaseSelected != null) {
            onCaseSelected.accept(getSelectedCase());
        }
    }

    // 记录当前选中案例的路径，用于重建树后恢复选中
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
                tree.setSelectionPath(new TreePath(entry.getKey().getPath()));
                return;
            }
        }
    }
}