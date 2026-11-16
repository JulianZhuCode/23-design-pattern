package com.zhuzz.design.patternz.factorymethod.loggerfactory;

/**
 * 具体产品：文件日志
 * Concrete product: file logger
 */
public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("[File] writing to log file: " + message);
    }
}