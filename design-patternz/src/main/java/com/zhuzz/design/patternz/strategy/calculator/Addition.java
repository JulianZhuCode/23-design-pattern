package com.zhuzz.design.patternz.strategy.calculator;

/**
 * 具体策略：加法
 * Concrete strategy: addition
 */
public class Addition implements MathOperation {
    @Override
    public int operate(int a, int b) {
        return a + b;
    }
}