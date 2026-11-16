package com.zhuzz.design.patternz.chainofresponsibility.reimbursement;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体处理者：财务部门，兜底处理剩余请求
 * Concrete handler: finance, fallback
 */
public class FinanceHandler extends ReimbursementHandler {
    @Override
    public void handleRequest(ReimbursementRequest request) {
        Messages.println("finance.handle", request.getDescription());
    }
}