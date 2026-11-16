package com.zhuzz.design.patternz.chainofresponsibility.logfilter;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体处理者：DEBUG 日志记录器
 * Concrete handler: debug logger
 */
public class DebugLogger extends Logger {
    @Override
    public void handle(LogMessage message) {
        if (message.getLevel() == LogLevel.DEBUG) {
            Messages.println("debugLogger.handle", message.getContent());
        } else if (successor != null) {
            successor.handle(message);
        }
    }
}