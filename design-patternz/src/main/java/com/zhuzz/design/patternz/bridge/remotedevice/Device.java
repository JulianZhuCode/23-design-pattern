package com.zhuzz.design.patternz.bridge.remotedevice;

/**
 * 实现接口：设备
 * Implementor: device
 */
public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int volume);

    int getChannel();

    void setChannel(int channel);
}