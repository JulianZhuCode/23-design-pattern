package com.zhuzz.design.patternz.strategy.calculator;

/** 策略接口：声明运算策略 | Strategy: declares operation */
public interface MathOperation {
    int operate(int a, int b);
}