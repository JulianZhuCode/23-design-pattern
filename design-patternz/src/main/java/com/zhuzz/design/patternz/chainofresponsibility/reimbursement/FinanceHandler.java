package com.zhuzz.design.patternz.chainofresponsibility.reimbursement;

/**
 * 具体处理者：财务部门，兜底处理剩余请求
 * Concrete handler: finance, fallback
 */
public class FinanceHandler extends ReimbursementHandler {
    @Override
    public void handleRequest(ReimbursementRequest request) {
        System.out.println("财务部门处理报销请求：" + request.getDescription());
    }
}