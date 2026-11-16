package com.zhuzz.design.patternz.chainofresponsibility.reimbursement;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体处理者：部门主管，处理 1000 元以内报销
 * Concrete handler: department head, ≤1000
 */
public class DepartmentHeadHandler extends ReimbursementHandler {
    @Override
    public void handleRequest(ReimbursementRequest request) {
        if (request.getAmount() <= 1000) {
            Messages.println("head.handle", request.getDescription());
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}