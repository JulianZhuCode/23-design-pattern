package com.zhuzz.design.patternz.facade.hometheater;

import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 外观模式演示：一键完成观影准备
 * Facade demo: one-click movie setup
 */
public class HomeTheaterDemo extends DemoSupport {
    @Override public I18nMessages pattern() { return PAT_FACADE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Home Theater", Locale.SIMPLIFIED_CHINESE, "家庭影院");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "action",
                Map.of(Locale.ENGLISH, "Action", Locale.SIMPLIFIED_CHINESE, "操作"),
                PlaygroundInput.Type.CHOICE,
                List.of("Watch", "End"),
                "Watch"));
    }

    @Override public void run(Map<String, String> values) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        // 按用户选择执行观影或结束，体验门面封装的一键操作
        // watch or end based on the user's choice to experience the facade's one-click ops
        String action = values.getOrDefault("action", "Watch");
        if ("End".equals(action)) {
            homeTheater.endMovie();
        } else {
            homeTheater.watchMovie();
        }
    }
}