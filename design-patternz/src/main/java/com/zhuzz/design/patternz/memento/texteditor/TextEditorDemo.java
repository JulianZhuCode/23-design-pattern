package com.zhuzz.design.patternz.memento.texteditor;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 备忘录模式演示：文本编辑器的撤销/重做
 * Memento demo: text editor undo/redo
 */
public class TextEditorDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_MEMENTO; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Text Editor", Locale.SIMPLIFIED_CHINESE, "文本编辑器");
    }
    @Override public void run() {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // 设置初始状态 | set initial state
        originator.setState("State 1");
        System.out.println("Current State: " + originator.getState());

        // 创建备忘录并保存状态 | create memento and save state
        caretaker.setMemento(originator.createMemento());

        // 修改状态 | change state
        originator.setState("State 2");
        System.out.println("Updated State: " + originator.getState());

        // 恢复之前的状态 | restore previous state
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("Restored State: " + originator.getState());
    }
}