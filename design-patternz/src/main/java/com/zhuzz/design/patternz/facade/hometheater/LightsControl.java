package com.zhuzz.design.patternz.facade.hometheater;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 子系统：灯光控制
 * Subsystem: lights
 */
public class LightsControl {
    public void turnOn() {
        Messages.println("lights.turnOn");
    }

    public void turnOff() {
        Messages.println("lights.turnOff");
    }
}