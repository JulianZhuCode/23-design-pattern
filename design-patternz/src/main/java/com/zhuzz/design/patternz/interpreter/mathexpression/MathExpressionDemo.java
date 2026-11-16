package com.zhuzz.design.patternz.interpreter.mathexpression;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 解释器模式演示：解析并计算表达式
 * Interpreter demo: parse and evaluate
 */
public class MathExpressionDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_INTERPRETER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Math Expression", Locale.SIMPLIFIED_CHINESE, "数学表达式");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        // 构建表达式：2 + (3 - 1)
        // build: 2 + (3 - 1)
        Expression expression = new AddExpression(
                new NumberExpression(2),
                new SubtractExpression(
                        new NumberExpression(3),
                        new NumberExpression(1)
                )
        );

        // 解释并计算
        // interpret and compute
        int result = expression.interpret();
        // 输出 4
        // prints 4
        System.out.println("Result: " + result);
    }
}