package com.zhuzz.design.patternz.strategy.calculator;

/** 具体策略：乘法 | Concrete strategy: multiplication */
public class Multiplication implements MathOperation {
    @Override
    public int operate(int a, int b) {
        return a * b;
    }
}