package com.zhuzz.design.patternz.facade.hometheater;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 子系统：音响系统
 * Subsystem: stereo
 */
public class StereoSystem {
    public void turnOn() {
        Messages.println("stereo.turnOn");
    }

    public void turnOff() {
        Messages.println("stereo.turnOff");
    }
}