package com.zhuzz.design.patternz.interpreter.booleanexpression;

/**
 * 非终结符表达式：与
 * Non-terminal expression: AND
 */
public class AndExpression implements BooleanExpression {
    private final BooleanExpression left;
    private final BooleanExpression right;

    public AndExpression(BooleanExpression left, BooleanExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(Context context) {
        return left.interpret(context) && right.interpret(context);
    }
}