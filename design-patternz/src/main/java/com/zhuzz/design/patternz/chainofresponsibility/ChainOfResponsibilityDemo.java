package com.zhuzz.design.patternz.chainofresponsibility;

import com.zhuzz.design.lab.BaseDemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ChainOfResponsibilityDemo extends BaseDemoCase {
    @Override public I18nMessages category() { return CAT_BEHAVIORAL; }
    @Override public I18nMessages pattern() { return PAT_CHAIN_OF_RESPONSIBILITY; }
    @Override public void run() { ReimbursementCase.main(new String[0]); }
}