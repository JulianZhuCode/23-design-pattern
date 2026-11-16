package com.zhuzz.design.patternz.bridge.remotedevice;

/**
 * 具体实现：收音机
 * Concrete implementor: radio
 */
public class Radio implements Device {
    private boolean enabled = false;
    private int volume = 20;
    private int channel = 88;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
    }

    @Override
    public void disable() {
        enabled = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "Radio [enabled=" + enabled + ", volume=" + volume + ", channel=" + channel + "]";
    }
}