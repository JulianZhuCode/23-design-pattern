package com.zhuzz.design.patternz.interpreter.booleanexpression;

/**
 * 终结符表达式：变量
 * Terminal expression: variable
 */
public class VariableExpression implements BooleanExpression {
    private final String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public boolean interpret(Context context) {
        return context.lookup(name);
    }
}