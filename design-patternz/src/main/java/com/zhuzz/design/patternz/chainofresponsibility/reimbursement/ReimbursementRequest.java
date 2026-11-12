package com.zhuzz.design.patternz.chainofresponsibility.reimbursement;

/** 报销请求：包含金额与说明 | Request: amount and description */
public class ReimbursementRequest {
    private double amount;
    private String description;

    public ReimbursementRequest(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}