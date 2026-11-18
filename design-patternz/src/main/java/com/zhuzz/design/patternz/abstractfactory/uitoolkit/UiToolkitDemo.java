package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.PAT_ABSTRACT_FACTORY;

public class UiToolkitDemo extends DemoSupport {

    private static final String PLATFORM = "platform";
    private static final String TEXT = "text";

    @Override public I18nMessages pattern() { return PAT_ABSTRACT_FACTORY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "UI Toolkit", Locale.SIMPLIFIED_CHINESE, "跨平台 UI 组件");
    }

    @Override public List<PlaygroundInput> inputs() {
        return List.of(
                new PlaygroundInput(
                        PLATFORM,
                        Map.of(Locale.ENGLISH, "Platform", Locale.SIMPLIFIED_CHINESE, "平台"),
                        PlaygroundInput.Type.CHOICE,
                        List.of("Windows", "Mac"),
                        "Windows"),
                new PlaygroundInput(
                        TEXT,
                        Map.of(Locale.ENGLISH, "Input text", Locale.SIMPLIFIED_CHINESE, "输入文本"),
                        PlaygroundInput.Type.TEXT,
                        List.of(),
                        "Hello"));
    }

    @Override public void run(Map<String, String> values) {
        String platform = values.getOrDefault(PLATFORM, "Windows");
        String text = values.getOrDefault(TEXT, "Hello");
        UIFactory factory = "Mac".equals(platform) ? new MacFactory() : new WindowsFactory();

        factory.createButton().click();
        factory.createTextField().input(text);
    }
}