package com.zhuzz.design.patternz.strategy.calculator;

/** 具体策略：减法 | Concrete strategy: subtraction */
public class Subtraction implements MathOperation {
    @Override
    public int operate(int a, int b) {
        return a - b;
    }
}