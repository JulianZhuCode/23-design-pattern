package com.zhuzz.design.patternz.chainofresponsibility.reimbursement;

/**
 * 抽象处理者：维护后继者并声明处理接口
 * Handler: holds successor, declares handle()
 */
public abstract class ReimbursementHandler {
    protected ReimbursementHandler successor;

    public void setSuccessor(ReimbursementHandler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(ReimbursementRequest request);
}