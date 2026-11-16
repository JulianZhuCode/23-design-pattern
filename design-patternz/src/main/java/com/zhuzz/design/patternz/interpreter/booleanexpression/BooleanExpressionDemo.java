package com.zhuzz.design.patternz.interpreter.booleanexpression;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class BooleanExpressionDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_INTERPRETER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Boolean Expression", Locale.SIMPLIFIED_CHINESE, "布尔表达式");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        Context context = new Context();
        context.assign("A", true);
        context.assign("B", false);
        context.assign("C", true);

        // 构造表达式：(A AND B) OR (NOT C)
        // build: (A AND B) OR (NOT C)
        BooleanExpression expression = new OrExpression(
                new AndExpression(
                        new VariableExpression("A"),
                        new VariableExpression("B")
                ),
                new NotExpression(new VariableExpression("C"))
        );

        // 解释并计算：(true AND false) OR (NOT true) = false
        // interpret: (true AND false) OR (NOT true) = false
        boolean result = expression.interpret(context);
        System.out.println("Result: " + result);
    }
}