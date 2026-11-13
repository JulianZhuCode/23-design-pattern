package com.zhuzz.design.patternz.interpreter.mathexpression;

/**
 * 非终结符表达式：减法
 * Non-terminal expression: subtraction
 */
public class SubtractExpression implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public SubtractExpression(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public int interpret() {
        return leftOperand.interpret() - rightOperand.interpret();
    }
}