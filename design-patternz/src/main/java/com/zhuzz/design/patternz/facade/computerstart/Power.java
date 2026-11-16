package com.zhuzz.design.patternz.facade.computerstart;

/**
 * 子系统：电源
 * Subsystem: power
 */
public class Power {
    public void on() {
        System.out.println("Power is on");
    }

    public void off() {
        System.out.println("Power is off");
    }
}