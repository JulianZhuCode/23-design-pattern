package com.zhuzz.design.patternz.interpreter;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class InterpreterDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_INTERPRETER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Math Expression", Locale.SIMPLIFIED_CHINESE, "数学表达式");
    }
    @Override public void run() { MathExpressionCase.main(new String[0]); }
}