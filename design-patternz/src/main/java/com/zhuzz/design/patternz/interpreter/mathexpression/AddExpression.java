package com.zhuzz.design.patternz.interpreter.mathexpression;

/** 非终结符表达式：加法 | Non-terminal expression: addition */
public class AddExpression implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public AddExpression(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public int interpret() {
        return leftOperand.interpret() + rightOperand.interpret();
    }
}