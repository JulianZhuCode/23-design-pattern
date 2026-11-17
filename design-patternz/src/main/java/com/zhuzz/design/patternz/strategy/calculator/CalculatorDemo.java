package com.zhuzz.design.patternz.strategy.calculator;

import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;
import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 策略模式演示：可切换运算策略的计算器
 * Strategy demo: calculator with switchable ops
 */
public class CalculatorDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_STRATEGY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Calculator", Locale.SIMPLIFIED_CHINESE, "计算器策略");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(
                new PlaygroundInput(
                        "op",
                        Map.of(Locale.ENGLISH, "Operation", Locale.SIMPLIFIED_CHINESE, "运算"),
                        PlaygroundInput.Type.CHOICE,
                        List.of("Addition", "Subtraction", "Multiplication"),
                        "Addition"),
                new PlaygroundInput(
                        "a",
                        Map.of(Locale.ENGLISH, "Operand A", Locale.SIMPLIFIED_CHINESE, "操作数 A"),
                        PlaygroundInput.Type.TEXT,
                        List.of(),
                        "5"),
                new PlaygroundInput(
                        "b",
                        Map.of(Locale.ENGLISH, "Operand B", Locale.SIMPLIFIED_CHINESE, "操作数 B"),
                        PlaygroundInput.Type.TEXT,
                        List.of(),
                        "3"));
    }

    @Override public void run(Map<String, String> values) {
        Calculator calculator = new Calculator();

        // 按用户选择的运算与操作数执行一次计算
        // perform one calculation with the user-selected operation and operands
        String op = values.getOrDefault("op", "Addition");
        if ("Subtraction".equals(op)) {
            calculator.setOperation(new Subtraction());
        } else if ("Multiplication".equals(op)) {
            calculator.setOperation(new Multiplication());
        } else {
            calculator.setOperation(new Addition());
        }
        // 操作数必须为整数，非法输入给出友好提示并中止
        // Operands must be integers; abort with a friendly hint on invalid input
        int a;
        int b;
        try {
            a = Integer.parseInt(values.getOrDefault("a", "5"));
            b = Integer.parseInt(values.getOrDefault("b", "3"));
        } catch (NumberFormatException e) {
            Messages.println("calculator.invalidOperand");
            return;
        }
        int result = calculator.performOperation(a, b);
        Messages.println("calculator.result", op, result);
    }
}