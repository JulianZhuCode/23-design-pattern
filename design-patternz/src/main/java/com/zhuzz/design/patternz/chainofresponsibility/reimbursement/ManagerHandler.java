package com.zhuzz.design.patternz.chainofresponsibility.reimbursement;

/** 具体处理者：经理，处理 1000 元以内的报销 */
public class ManagerHandler extends ReimbursementHandler {
    @Override
    public void handleRequest(ReimbursementRequest request) {
        if (request.getAmount() <= 1000) {
            System.out.println("经理处理报销请求：" + request.getDescription());
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}