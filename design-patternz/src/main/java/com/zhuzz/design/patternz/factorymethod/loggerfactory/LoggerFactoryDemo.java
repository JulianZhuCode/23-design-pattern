package com.zhuzz.design.patternz.factorymethod.loggerfactory;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class LoggerFactoryDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_FACTORY_METHOD; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Logger Factory", Locale.SIMPLIFIED_CHINESE, "日志工厂");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(
                new PlaygroundInput(
                        "type",
                        Map.of(Locale.ENGLISH, "Logger Type", Locale.SIMPLIFIED_CHINESE, "日志类型"),
                        PlaygroundInput.Type.CHOICE,
                        List.of("Console", "File", "Database"),
                        "Console"),
                new PlaygroundInput(
                        "message",
                        Map.of(Locale.ENGLISH, "Message", Locale.SIMPLIFIED_CHINESE, "日志内容"),
                        PlaygroundInput.Type.TEXT,
                        List.of(),
                        "Application started"));
    }

    @Override public void run(Map<String, String> values) {
        // 客户端只面向抽象工厂与抽象产品，具体类型由各工厂决定
        // The client depends only on the abstract factory/product; each factory picks the concrete type
        String type = values.getOrDefault("type", "Console");
        LoggerFactory factory = new ConsoleLoggerFactory();
        if ("File".equals(type)) {
            factory = new FileLoggerFactory();
        } else if ("Database".equals(type)) {
            factory = new DatabaseLoggerFactory();
        }
        Logger logger = factory.createLogger();
        logger.log(values.getOrDefault("message", "Application started"));
    }
}