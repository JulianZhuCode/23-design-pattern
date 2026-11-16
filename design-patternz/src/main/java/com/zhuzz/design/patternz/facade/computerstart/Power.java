package com.zhuzz.design.patternz.facade.computerstart;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 子系统：电源
 * Subsystem: power
 */
public class Power {
    public void on() {
        Messages.println("power.on");
    }

    public void off() {
        Messages.println("power.off");
    }
}