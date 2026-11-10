package com.zhuzz.design.patternz.interpreter;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class InterpreterDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_BEHAVIORAL; }
    @Override public I18nMessages pattern() { return PAT_INTERPRETER; }
    @Override public void run() { MathExpressionCase.main(new String[0]); }
}