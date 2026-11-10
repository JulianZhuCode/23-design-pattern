package com.zhuzz.design.patternz.command.lightcontrol;

/** 命令接口：可执行、可撤销 */
public interface Command {
    void execute();

    void undo();
}