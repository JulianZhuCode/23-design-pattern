package com.zhuzz.design.patternz.command.texteditorcommand;

/**
 * 接收者：文本编辑器，维护文本内容
 * Receiver: text editor holding the text
 */
public class TextEditor {
    private final StringBuilder text = new StringBuilder();

    public void type(String content) {
        text.append(content);
    }

    public void deleteLast(int length) {
        int from = Math.max(0, text.length() - length);
        text.delete(from, text.length());
    }

    public String getText() {
        return text.toString();
    }
}