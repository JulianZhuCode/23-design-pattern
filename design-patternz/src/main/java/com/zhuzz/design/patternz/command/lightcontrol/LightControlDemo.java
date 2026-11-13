package com.zhuzz.design.patternz.command.lightcontrol;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 命令模式演示：遥控器开灯/关灯
 * Command demo: remote light on/off
 */
public class LightControlDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_COMMAND; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Light Switch", Locale.SIMPLIFIED_CHINESE, "灯光控制");
    }
    @Override public void run() {
        Light livingRoomLight = new Light();

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(livingRoomLightOn);
        remote.pressButton(); // 开灯 | turn on
        remote.pressUndoButton(); // 撤销：关灯 | undo: turn off

        remote.setCommand(livingRoomLightOff);
        remote.pressButton(); // 关灯 | turn off
        remote.pressUndoButton(); // 撤销：开灯 | undo: turn on
    }
}