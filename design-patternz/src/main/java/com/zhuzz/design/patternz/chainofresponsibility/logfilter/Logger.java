package com.zhuzz.design.patternz.chainofresponsibility.logfilter;

/**
 * 抽象处理者：日志记录器，维护后继者并声明处理接口
 * Handler: logger, holds successor, declares handle()
 */
public abstract class Logger {
    protected Logger successor;

    public void setSuccessor(Logger successor) {
        this.successor = successor;
    }

    public abstract void handle(LogMessage message);
}