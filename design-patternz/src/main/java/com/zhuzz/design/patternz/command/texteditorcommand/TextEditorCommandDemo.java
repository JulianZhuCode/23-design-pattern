package com.zhuzz.design.patternz.command.texteditorcommand;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class TextEditorCommandDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_COMMAND; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Text Editor", Locale.SIMPLIFIED_CHINESE, "文本编辑器");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "text",
                Map.of(Locale.ENGLISH, "Text", Locale.SIMPLIFIED_CHINESE, "文本"),
                PlaygroundInput.Type.TEXT,
                List.of(),
                "Hello"));
    }

    @Override public void run(Map<String, String> values) {
        TextEditor editor = new TextEditor();
        EditorInvoker invoker = new EditorInvoker();

        // 按用户输入的文字执行一次输入命令，再演示撤销
        // type the user-provided text, then demonstrate undo
        String text = values.getOrDefault("text", "Hello");
        invoker.execute(new TypeCommand(editor, text));
        System.out.println("Text: " + editor.getText());

        invoker.undo();
        System.out.println("After undo: " + editor.getText());
    }
}