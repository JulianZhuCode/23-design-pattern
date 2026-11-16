package com.zhuzz.design.patternz.factorymethod.loggerfactory;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体产品：控制台日志
 * Concrete product: console logger
 */
public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        Messages.println("logger.console", message);
    }
}