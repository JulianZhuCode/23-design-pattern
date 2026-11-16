package com.zhuzz.design.patternz.chainofresponsibility.logfilter;

/**
 * 日志消息：级别与内容
 * Log message: level and content
 */
public class LogMessage {
    private LogLevel level;
    private String content;

    public LogMessage(LogLevel level, String content) {
        this.level = level;
        this.content = content;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getContent() {
        return content;
    }
}