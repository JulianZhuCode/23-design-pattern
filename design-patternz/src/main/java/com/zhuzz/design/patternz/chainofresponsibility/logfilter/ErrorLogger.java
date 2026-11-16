package com.zhuzz.design.patternz.chainofresponsibility.logfilter;

/**
 * 具体处理者：ERROR 日志记录器
 * Concrete handler: error logger
 */
public class ErrorLogger extends Logger {
    @Override
    public void handle(LogMessage message) {
        if (message.getLevel() == LogLevel.ERROR) {
            System.out.println("[ERROR] " + message.getContent());
        } else if (successor != null) {
            successor.handle(message);
        }
    }
}