package com.zhuzz.design.lab.ui;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18n;
import com.zhuzz.design.lab.i18n.I18nMessages;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.Component;

/**
 * 案例树的单元格渲染器：分类/模式节点按 I18nMessages 取文案，
 * 案例节点按 DemoCase 的多语言显示名渲染。
 * Tree cell renderer: renders category/pattern nodes via I18nMessages,
 * and case nodes via the case's localized display name.
 */
class I18nRenderer extends DefaultTreeCellRenderer {

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