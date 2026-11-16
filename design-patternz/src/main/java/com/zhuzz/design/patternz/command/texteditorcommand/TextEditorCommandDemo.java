package com.zhuzz.design.patternz.command.texteditorcommand;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class TextEditorCommandDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_COMMAND; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Text Editor", Locale.SIMPLIFIED_CHINESE, "文本编辑器");
    }
    @Override public void run() {
        TextEditor editor = new TextEditor();
        EditorInvoker invoker = new EditorInvoker();

        invoker.execute(new TypeCommand(editor, "Hello"));
        invoker.execute(new TypeCommand(editor, " World"));
        System.out.println("Text: " + editor.getText());

        // 撤销上次输入
        // undo last typing
        invoker.undo();
        System.out.println("After undo: " + editor.getText());

        invoker.execute(new BackspaceCommand(editor, 2));
        System.out.println("After backspace: " + editor.getText());

        // 撤销退格
        // undo backspace
        invoker.undo();
        System.out.println("After undo backspace: " + editor.getText());
    }
}