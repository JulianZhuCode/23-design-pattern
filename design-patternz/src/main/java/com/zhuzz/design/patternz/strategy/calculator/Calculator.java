package com.zhuzz.design.patternz.strategy.calculator;

/** 上下文：持有一个运算策略，可动态切换并执行运算 | Context: holds and switches strategy */
public class Calculator {
    private MathOperation operation;

    public void setOperation(MathOperation operation) {
        this.operation = operation;
    }

    public int performOperation(int a, int b) {
        if (operation != null) {
            return operation.operate(a, b);
        }
        throw new IllegalStateException("No operation set");
    }
}