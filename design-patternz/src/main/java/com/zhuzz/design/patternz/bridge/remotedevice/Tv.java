package com.zhuzz.design.patternz.bridge.remotedevice;

/**
 * 具体实现：电视
 * Concrete implementor: TV
 */
public class Tv implements Device {
    private boolean enabled = false;
    private int volume = 30;
    private int channel = 1;

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
        return "Tv [enabled=" + enabled + ", volume=" + volume + ", channel=" + channel + "]";
    }
}