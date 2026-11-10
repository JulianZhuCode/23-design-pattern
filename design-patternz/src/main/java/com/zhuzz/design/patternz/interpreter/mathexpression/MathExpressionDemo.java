package com.zhuzz.design.patternz.interpreter.mathexpression;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class MathExpressionDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_INTERPRETER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Math Expression", Locale.SIMPLIFIED_CHINESE, "数学表达式");
    }
    @Override public void run() {
        // 构建表达式：2 + (3 - 1)
        Expression expression = new AddExpression(
                new NumberExpression(2),
                new SubtractExpression(
                        new NumberExpression(3),
                        new NumberExpression(1)
                )
        );

        // 解释并计算表达式的值
        int result = expression.interpret();
        System.out.println("Result: " + result); // 输出: Result: 4
    }
}