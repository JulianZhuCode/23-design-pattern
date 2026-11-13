package com.zhuzz.design.patternz.command.lightcontrol;

/**
 * 具体命令：开灯，撤销为关灯
 * Concrete command: turn on, undo turns off
 */
public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}