package com.zhuzz.design.patternz.facade.hometheater;

/** 子系统：音响系统 */
public class StereoSystem {
    public void turnOn() {
        System.out.println("Stereo System is turned on");
    }

    public void turnOff() {
        System.out.println("Stereo System is turned off");
    }
}