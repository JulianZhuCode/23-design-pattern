package com.zhuzz.design.patternz.builder.computerbuilder;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ComputerBuilderDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_BUILDER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Computer Builder", Locale.SIMPLIFIED_CHINESE, "电脑组装");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "type",
                Map.of(Locale.ENGLISH, "Computer Type", Locale.SIMPLIFIED_CHINESE, "电脑类型"),
                PlaygroundInput.Type.CHOICE,
                List.of("Gaming", "Office"),
                "Gaming"));
    }

    @Override public void run(Map<String, String> values) {
        // 同一指挥者 + 不同建造者，产出不同配置的电脑
        // Same director + different builders yield different configurations
        String type = values.getOrDefault("type", "Gaming");
        ComputerBuilder builder = new GamingComputerBuilder();
        if ("Office".equals(type)) {
            builder = new OfficeComputerBuilder();
        }
        Director director = new Director(builder);
        Computer computer = director.constructComputer();
        Messages.println("computerBuilder.result", type, computer);
    }
}