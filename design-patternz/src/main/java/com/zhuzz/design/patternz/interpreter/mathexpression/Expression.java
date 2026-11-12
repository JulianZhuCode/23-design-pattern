package com.zhuzz.design.patternz.interpreter.mathexpression;

/** 抽象表达式：解释为整数 | Abstract expression: interprets to an integer */
public interface Expression {
    int interpret();
}