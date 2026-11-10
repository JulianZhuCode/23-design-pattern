package com.zhuzz.design.patternz.visitor;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class VisitorDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_BEHAVIORAL; }
    @Override public I18nMessages pattern() { return PAT_VISITOR; }
    @Override public void run() { AreaCalculatorCase.main(new String[0]); }
}