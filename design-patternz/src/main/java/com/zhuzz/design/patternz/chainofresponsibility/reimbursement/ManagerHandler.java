package com.zhuzz.design.patternz.chainofresponsibility.reimbursement;

/**
 * 具体处理者：经理，处理 5000 元以内报销
 * Concrete handler: manager, ≤5000
 */
public class ManagerHandler extends ReimbursementHandler {
    @Override
    public void handleRequest(ReimbursementRequest request) {
        if (request.getAmount() <= 5000) {
            System.out.println("经理处理报销请求：" + request.getDescription());
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}