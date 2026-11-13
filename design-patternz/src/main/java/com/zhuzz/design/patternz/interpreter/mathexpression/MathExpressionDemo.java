package com.zhuzz.design.patternz.interpreter.mathexpression;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 解释器模式演示：解析并计算表达式
 * Interpreter demo: parse and evaluate
 */
public class MathExpressionDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_INTERPRETER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Math Expression", Locale.SIMPLIFIED_CHINESE, "数学表达式");
    }
    @Override public void run() {
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