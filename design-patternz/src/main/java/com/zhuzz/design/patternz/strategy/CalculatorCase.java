package com.zhuzz.design.patternz.strategy;

/**
 * 策略模式 - 计算器案例
 *
 * @author zhuzz
 * 2023/8/29 17:57
 */
public class CalculatorCase {


    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.setOperation(new Addition());
        int result1 = calculator.performOperation(5, 3);
        System.out.println("Addition Result: " + result1);

        calculator.setOperation(new Subtraction());
        int result2 = calculator.performOperation(10, 4);
        System.out.println("Subtraction Result: " + result2);

        calculator.setOperation(new Multiplication());
        int result3 = calculator.performOperation(6, 2);
        System.out.println("Multiplication Result: " + result3);

    }
    interface MathOperation {
        int operate(int a, int b);
    }

    static class Addition implements MathOperation {
        @Override
        public int operate(int a, int b) {
            return a + b;
        }
    }

    static class Subtraction implements MathOperation {
        @Override
        public int operate(int a, int b) {
            return a - b;
        }
    }

    static class Multiplication implements MathOperation {
        @Override
        public int operate(int a, int b) {
            return a * b;
        }
    }

    static class Calculator {
        private MathOperation operation;

        public void setOperation(MathOperation operation) {
            this.operation = operation;
        }

        public int performOperation(int a, int b) {
            if (operation != null) {
                return operation.operate(a, b);
            }
            throw new IllegalStateException("No operation set");
        }
    }

}