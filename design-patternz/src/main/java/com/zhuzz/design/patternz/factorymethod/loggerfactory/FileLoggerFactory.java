package com.zhuzz.design.patternz.factorymethod.loggerfactory;

/**
 * 具体工厂：创建文件日志记录器
 * Concrete factory: file logger
 */
public class FileLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}