package com.zhuzz.design.patternz.command.lightcontrol;

/**
 * 调用者：遥控器，持有命令并触发执行 / 撤销
 * Invoker: remote holding a command
 */
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndoButton() {
        command.undo();
    }
}