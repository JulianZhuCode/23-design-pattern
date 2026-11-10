package com.zhuzz.design.patternz.chainofresponsibility.reimbursement;

/** 具体处理者：财务部门，最终兜底处理所有剩余请求 */
public class FinanceHandler extends ReimbursementHandler {
    @Override
    public void handleRequest(ReimbursementRequest request) {
        System.out.println("财务部门处理报销请求：" + request.getDescription());
    }
}