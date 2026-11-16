package com.zhuzz.design.patternz.chainofresponsibility.logfilter;

import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class LogFilterDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_CHAIN_OF_RESPONSIBILITY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Log Filter", Locale.SIMPLIFIED_CHINESE, "日志过滤");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "level",
                Map.of(Locale.ENGLISH, "Log Level", Locale.SIMPLIFIED_CHINESE, "日志级别"),
                PlaygroundInput.Type.CHOICE,
                List.of("DEBUG", "INFO", "ERROR"),
                "DEBUG"));
    }

    @Override public void run(Map<String, String> values) {
        // 组装责任链：DEBUG -> INFO -> ERROR
        // build chain: DEBUG -> INFO -> ERROR
        Logger debugLogger = new DebugLogger();
        Logger infoLogger = new InfoLogger();
        Logger errorLogger = new ErrorLogger();

        debugLogger.setSuccessor(infoLogger);
        infoLogger.setSuccessor(errorLogger);

        // 按用户选择的日志级别构造一条消息，观察责任链如何传递
        // build one message at the user-selected level to observe the chain flow
        String level = values.getOrDefault("level", "DEBUG");
        LogLevel logLevel = switch (level) {
            case "INFO" -> LogLevel.INFO;
            case "ERROR" -> LogLevel.ERROR;
            default -> LogLevel.DEBUG;
        };
        debugLogger.handle(new LogMessage(logLevel, "沙盒日志消息"));
    }
}