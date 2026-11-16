package com.zhuzz.design.patternz.interpreter.booleanexpression;

/**
 * 非终结符表达式：非
 * Non-terminal expression: NOT
 */
public class NotExpression implements BooleanExpression {
    private final BooleanExpression expression;

    public NotExpression(BooleanExpression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret(Context context) {
        return !expression.interpret(context);
    }
}