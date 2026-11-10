package com.zhuzz.design.patternz.command.lightcontrol;

/** 接收者：电灯，真正执行开灯 / 关灯 */
public class Light {
    public void turnOn() {
        System.out.println("Light is on");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}