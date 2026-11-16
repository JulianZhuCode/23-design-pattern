package com.zhuzz.design.patternz.factorymethod.loggerfactory;

/**
 * 具体产品：控制台日志
 * Concrete product: console logger
 */
public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("[Console] " + message);
    }
}