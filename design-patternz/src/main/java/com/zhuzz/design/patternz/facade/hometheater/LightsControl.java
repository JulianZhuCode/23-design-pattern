package com.zhuzz.design.patternz.facade.hometheater;

/** 子系统：灯光控制 | Subsystem: lights */
public class LightsControl {
    public void turnOn() {
        System.out.println("Lights are turned on");
    }

    public void turnOff() {
        System.out.println("Lights are turned off");
    }
}