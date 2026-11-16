package com.zhuzz.design.patternz.facade.hometheater;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 子系统：投影仪
 * Subsystem: projector
 */
public class Projector {
    public void turnOn() {
        Messages.println("projector.turnOn");
    }

    public void turnOff() {
        Messages.println("projector.turnOff");
    }
}