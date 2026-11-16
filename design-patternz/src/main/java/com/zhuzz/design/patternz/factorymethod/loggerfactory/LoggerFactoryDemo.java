package com.zhuzz.design.patternz.factorymethod.loggerfactory;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class LoggerFactoryDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_FACTORY_METHOD; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Logger Factory", Locale.SIMPLIFIED_CHINESE, "日志工厂");
    }
    @Override public void run() {
        // 客户端只面向抽象工厂与抽象产品，具体类型由各工厂决定
        // The client depends only on the abstract factory/product; each factory picks the concrete type
        LoggerFactory consoleFactory = new ConsoleLoggerFactory();
        Logger consoleLogger = consoleFactory.createLogger();
        consoleLogger.log("Application started");

        LoggerFactory fileFactory = new FileLoggerFactory();
        Logger fileLogger = fileFactory.createLogger();
        fileLogger.log("User logged in");

        LoggerFactory databaseFactory = new DatabaseLoggerFactory();
        Logger databaseLogger = databaseFactory.createLogger();
        databaseLogger.log("Order created");
    }
}