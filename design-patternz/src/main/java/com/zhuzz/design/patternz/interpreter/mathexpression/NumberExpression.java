package com.zhuzz.design.patternz.interpreter.mathexpression;

/** 终结符表达式：数字 | Terminal expression: number */
public class NumberExpression implements Expression {
    private int value;

    public NumberExpression(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}