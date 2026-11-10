package com.zhuzz.design.patternz.strategy.calculator;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class CalculatorDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_STRATEGY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Calculator", Locale.SIMPLIFIED_CHINESE, "计算器策略");
    }
    @Override public void run() {
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
}