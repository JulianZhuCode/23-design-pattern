package com.zhuzz.design.patternz.memento.texteditor;

import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 备忘录模式演示：文本编辑器的撤销/重做
 * Memento demo: text editor undo/redo
 */
public class TextEditorDemo extends DemoSupport {
    @Override public I18nMessages pattern() { return PAT_MEMENTO; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Text Editor", Locale.SIMPLIFIED_CHINESE, "文本编辑器");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // 设置初始状态
        // set initial state
        originator.setState("State 1");
        Messages.println("currentState", originator.getState());

        // 创建备忘录并保存状态
        // create memento and save state
        caretaker.setMemento(originator.createMemento());

        // 修改状态
        // change state
        originator.setState("State 2");
        Messages.println("updatedState", originator.getState());

        // 恢复之前的状态
        // restore previous state
        originator.restoreMemento(caretaker.getMemento());
        Messages.println("restoredState", originator.getState());
    }
}