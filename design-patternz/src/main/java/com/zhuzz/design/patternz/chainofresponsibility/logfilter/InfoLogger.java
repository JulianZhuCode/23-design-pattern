package com.zhuzz.design.patternz.chainofresponsibility.logfilter;

/**
 * 具体处理者：INFO 日志记录器
 * Concrete handler: info logger
 */
public class InfoLogger extends Logger {
    @Override
    public void handle(LogMessage message) {
        if (message.getLevel() == LogLevel.INFO) {
            System.out.println("[INFO] " + message.getContent());
        } else if (successor != null) {
            successor.handle(message);
        }
    }
}