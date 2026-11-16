package com.zhuzz.design.patternz.command.lightcontrol;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 接收者：电灯，真正执行开灯 / 关灯
 * Receiver: light performing on/off
 */
public class Light {
    public void turnOn() {
        Messages.println("light.on");
    }

    public void turnOff() {
        Messages.println("light.off");
    }
}