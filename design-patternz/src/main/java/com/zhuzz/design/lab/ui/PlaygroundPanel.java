package com.zhuzz.design.lab.ui;

import com.zhuzz.design.lab.i18n.I18n;
import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.PLAYGROUND_TITLE;

/**
 * 参数沙盒面板：根据 PlaygroundCase 声明的输入项动态生成控件，
 * 供用户选择参数后运行案例；非参数化案例时隐藏。
 * Playground panel: dynamically renders controls from a PlaygroundCase's inputs,
 * so users can choose parameters before running; hidden for non-playground cases.
 */
public class PlaygroundPanel extends JPanel {

    private final Map<String, JComboBox<String>> choiceControls = new LinkedHashMap<>();
    private final Map<String, JTextField> textControls = new LinkedHashMap<>();

    public PlaygroundPanel() {
        setLayout(new GridBagLayout());
        refreshTexts();
        setVisible(false);
    }

    /**
     * 为给定案例重建输入控件；传 null 则清空并隐藏。
     * Rebuilds input controls for the given case; null clears and hides the panel.
     */
    public void showFor(PlaygroundCase demoCase) {
        removeAll();
        choiceControls.clear();
        textControls.clear();

        if (demoCase == null) {
            setVisible(false);
            revalidate();
            repaint();
            return;
        }

        int row = 0;
        for (PlaygroundInput input : demoCase.inputs()) {
            addLabel(input, row);
            addControl(input, row);
            row++;
        }

        setVisible(true);
        revalidate();
        repaint();
    }

    /** 收集用户当前填写的参数值。Collect the values the user has entered. */
    public Map<String, String> collectValues() {
        Map<String, String> values = new LinkedHashMap<>();
        choiceControls.forEach((id, combo) -> values.put(id, (String) combo.getSelectedItem()));
        textControls.forEach((id, field) -> values.put(id, field.getText()));
        return values;
    }

    /** 语言切换后刷新标题。Refresh the titled border after a locale switch. */
    public void refreshTexts() {
        setBorder(BorderFactory.createTitledBorder(I18n.get(PLAYGROUND_TITLE)));
    }

    private void addLabel(PlaygroundInput input, int row) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 4, 2, 6);
        add(new JLabel(input.label(I18n.getCurrentLocale())), gbc);
    }

    private void addControl(PlaygroundInput input, int row) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 0, 2, 4);

        if (input.type() == PlaygroundInput.Type.CHOICE) {
            JComboBox<String> combo = new JComboBox<>();
            for (String choice : input.choices()) {
                combo.addItem(choice);
            }
            combo.setSelectedItem(input.defaultValue());
            choiceControls.put(input.id(), combo);
            add(combo, gbc);
        } else {
            JTextField field = new JTextField(input.defaultValue(), 12);
            textControls.put(input.id(), field);
            add(field, gbc);
        }
    }
}