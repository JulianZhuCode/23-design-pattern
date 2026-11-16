package com.zhuzz.design.patternz.factorymethod.loggerfactory;

/**
 * 具体产品：数据库日志
 * Concrete product: database logger
 */
public class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("[Database] inserting log row: " + message);
    }
}