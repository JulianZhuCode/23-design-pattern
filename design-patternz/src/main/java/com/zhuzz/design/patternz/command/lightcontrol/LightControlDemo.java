package com.zhuzz.design.patternz.command.lightcontrol;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 命令模式演示：遥控器开灯/关灯
 * Command demo: remote light on/off
 */
public class LightControlDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_COMMAND; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Light Switch", Locale.SIMPLIFIED_CHINESE, "灯光控制");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "action",
                Map.of(Locale.ENGLISH, "Action", Locale.SIMPLIFIED_CHINESE, "操作"),
                PlaygroundInput.Type.CHOICE,
                List.of("On", "Off"),
                "On"));
    }

    @Override public void run(Map<String, String> values) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        // 按用户选择开灯或关灯，并演示一次撤销
        // turn the light on or off per the user's choice, then demonstrate undo
        String action = values.getOrDefault("action", "On");
        if ("Off".equals(action)) {
            remote.setCommand(new LightOffCommand(light));
        } else {
            remote.setCommand(new LightOnCommand(light));
        }
        remote.pressButton();
        remote.pressUndoButton();
    }
}