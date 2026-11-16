package com.zhuzz.design.patternz.factorymethod.loggerfactory;

/**
 * 抽象工厂：声明创建日志记录器的工厂方法
 * Abstract factory: declares the factory method that creates a logger
 */
public abstract class LoggerFactory {

    /**
     * 工厂方法：由子类决定创建哪种日志记录器
     * Factory method: subclasses decide which logger to create
     */
    public abstract Logger createLogger();
}