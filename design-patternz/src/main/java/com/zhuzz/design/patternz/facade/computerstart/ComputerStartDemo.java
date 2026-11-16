package com.zhuzz.design.patternz.facade.computerstart;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ComputerStartDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_FACADE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "One-Click Boot", Locale.SIMPLIFIED_CHINESE, "电脑一键开机");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "action",
                Map.of(Locale.ENGLISH, "Action", Locale.SIMPLIFIED_CHINESE, "操作"),
                PlaygroundInput.Type.CHOICE,
                List.of("Start", "Shutdown"),
                "Start"));
    }

    @Override public void run(Map<String, String> values) {
        ComputerFacade computer = new ComputerFacade();

        // 按用户选择执行一键开机或关机，体验门面封装
        // boot or shut down per the user's choice to experience the facade
        String action = values.getOrDefault("action", "Start");
        if ("Shutdown".equals(action)) {
            computer.shutdown();
        } else {
            computer.start();
        }
    }
}