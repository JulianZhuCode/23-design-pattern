package com.zhuzz.design.patternz.bridge.remotedevice;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class RemoteDeviceDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_BRIDGE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Remote & Device", Locale.SIMPLIFIED_CHINESE, "遥控器与设备");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        // 同一遥控器抽象可以控制不同的设备
        // the same remote abstraction can control different devices
        Device tv = new Tv();
        RemoteControl tvRemote = new RemoteControl(tv);
        tvRemote.togglePower();
        tvRemote.volumeUp();
        tvRemote.channelUp();
        Messages.println("remotedevice.device", tv);

        Device radio = new Radio();
        AdvancedRemote radioRemote = new AdvancedRemote(radio);
        radioRemote.togglePower();
        radioRemote.volumeUp();
        radioRemote.mute();
        Messages.println("remotedevice.device", radio);
    }
}