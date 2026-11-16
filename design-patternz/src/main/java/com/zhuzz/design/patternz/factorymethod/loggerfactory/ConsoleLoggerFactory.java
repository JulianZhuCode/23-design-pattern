package com.zhuzz.design.patternz.factorymethod.loggerfactory;

/**
 * 具体工厂：创建控制台日志记录器
 * Concrete factory: console logger
 */
public class ConsoleLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new ConsoleLogger();
    }
}