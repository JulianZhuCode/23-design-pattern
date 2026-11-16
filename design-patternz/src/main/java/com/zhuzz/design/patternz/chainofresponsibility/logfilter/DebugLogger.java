package com.zhuzz.design.patternz.chainofresponsibility.logfilter;

/**
 * 具体处理者：DEBUG 日志记录器
 * Concrete handler: debug logger
 */
public class DebugLogger extends Logger {
    @Override
    public void handle(LogMessage message) {
        if (message.getLevel() == LogLevel.DEBUG) {
            System.out.println("[DEBUG] " + message.getContent());
        } else if (successor != null) {
            successor.handle(message);
        }
    }
}