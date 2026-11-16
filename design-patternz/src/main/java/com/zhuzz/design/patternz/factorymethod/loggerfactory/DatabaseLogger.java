package com.zhuzz.design.patternz.factorymethod.loggerfactory;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体产品：数据库日志
 * Concrete product: database logger
 */
public class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        Messages.println("logger.database", message);
    }
}