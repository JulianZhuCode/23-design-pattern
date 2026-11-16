package com.zhuzz.design.patternz.command.texteditorcommand;

/**
 * 命令接口：可执行、可撤销
 * Command: executable and undoable
 */
public interface Command {
    void execute();

    void undo();
}