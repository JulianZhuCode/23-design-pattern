package com.zhuzz.design.patternz.factorymethod.loggerfactory;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体产品：文件日志
 * Concrete product: file logger
 */
public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        Messages.println("logger.file", message);
    }
}