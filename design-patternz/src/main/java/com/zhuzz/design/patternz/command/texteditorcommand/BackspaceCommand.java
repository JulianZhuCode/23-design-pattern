package com.zhuzz.design.patternz.command.texteditorcommand;

/**
 * 具体命令：退格删除
 * Concrete command: backspace delete
 */
public class BackspaceCommand implements Command {
    private final TextEditor editor;
    private final int length;
    private String removed;

    public BackspaceCommand(TextEditor editor, int length) {
        this.editor = editor;
        this.length = length;
    }

    @Override
    public void execute() {
        int from = Math.max(0, editor.getText().length() - length);
        removed = editor.getText().substring(from);
        editor.deleteLast(length);
    }

    @Override
    public void undo() {
        editor.type(removed);
    }
}