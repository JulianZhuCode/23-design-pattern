package com.zhuzz.design.patternz.command.texteditorcommand;

/**
 * 具体命令：输入文本
 * Concrete command: type text
 */
public class TypeCommand implements Command {
    private final TextEditor editor;
    private final String content;

    public TypeCommand(TextEditor editor, String content) {
        this.editor = editor;
        this.content = content;
    }

    @Override
    public void execute() {
        editor.type(content);
    }

    @Override
    public void undo() {
        editor.deleteLast(content.length());
    }
}