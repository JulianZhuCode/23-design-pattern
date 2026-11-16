package com.zhuzz.design.patternz.interpreter.booleanexpression;

/**
 * 抽象表达式：解释为布尔值
 * Abstract expression: interprets to a boolean
 */
public interface BooleanExpression {
    boolean interpret(Context context);
}