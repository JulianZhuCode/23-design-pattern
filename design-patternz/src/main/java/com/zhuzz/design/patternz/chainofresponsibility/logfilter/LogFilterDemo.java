package com.zhuzz.design.patternz.chainofresponsibility.logfilter;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class LogFilterDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_CHAIN_OF_RESPONSIBILITY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Log Filter", Locale.SIMPLIFIED_CHINESE, "日志过滤");
    }
    @Override public void run() {
        // 组装责任链：DEBUG -> INFO -> ERROR
        // build chain: DEBUG -> INFO -> ERROR
        Logger debugLogger = new DebugLogger();
        Logger infoLogger = new InfoLogger();
        Logger errorLogger = new ErrorLogger();

        debugLogger.setSuccessor(infoLogger);
        infoLogger.setSuccessor(errorLogger);

        debugLogger.handle(new LogMessage(LogLevel.DEBUG, "调试信息"));
        debugLogger.handle(new LogMessage(LogLevel.INFO, "普通信息"));
        debugLogger.handle(new LogMessage(LogLevel.ERROR, "错误信息"));
    }
}