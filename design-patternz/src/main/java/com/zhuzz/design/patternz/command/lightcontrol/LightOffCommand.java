package com.zhuzz.design.patternz.command.lightcontrol;

/** 具体命令：关灯，撤销为开灯 */
public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}