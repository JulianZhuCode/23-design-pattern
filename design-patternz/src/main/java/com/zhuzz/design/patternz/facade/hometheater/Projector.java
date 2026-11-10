package com.zhuzz.design.patternz.facade.hometheater;

/** 子系统：投影仪 */
public class Projector {
    public void turnOn() {
        System.out.println("Projector is turned on");
    }

    public void turnOff() {
        System.out.println("Projector is turned off");
    }
}