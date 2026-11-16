package com.zhuzz.design.patternz.bridge.remotedevice;

/**
 * 扩展抽象化：高级遥控器，新增静音
 * Refined abstraction: advanced remote with mute
 */
public class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
    }
}