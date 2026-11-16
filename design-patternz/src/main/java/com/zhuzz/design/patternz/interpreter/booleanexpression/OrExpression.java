package com.zhuzz.design.patternz.interpreter.booleanexpression;

/**
 * 非终结符表达式：或
 * Non-terminal expression: OR
 */
public class OrExpression implements BooleanExpression {
    private final BooleanExpression left;
    private final BooleanExpression right;

    public OrExpression(BooleanExpression left, BooleanExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(Context context) {
        return left.interpret(context) || right.interpret(context);
    }
}