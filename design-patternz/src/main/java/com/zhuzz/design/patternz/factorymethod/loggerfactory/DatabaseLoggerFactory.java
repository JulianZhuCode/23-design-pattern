package com.zhuzz.design.patternz.factorymethod.loggerfactory;

/**
 * 具体工厂：创建数据库日志记录器
 * Concrete factory: database logger
 */
public class DatabaseLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}