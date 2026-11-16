package com.zhuzz.design.patternz.command.texteditorcommand;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 调用者：编辑器，执行命令并维护撤销历史
 * Invoker: editor executing commands with undo history
 */
public class EditorInvoker {
    private final Deque<Command> history = new ArrayDeque<>();

    public void execute(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
        }
    }
}