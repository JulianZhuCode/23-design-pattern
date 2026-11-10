package com.zhuzz.design.patternz.chainofresponsibility;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ChainOfResponsibilityDemo implements DemoCase {
    @Override public I18nMessages category() { return CAT_BEHAVIORAL; }
    @Override public I18nMessages pattern() { return PAT_CHAIN_OF_RESPONSIBILITY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Reimbursement", Locale.SIMPLIFIED_CHINESE, "报销审批");
    }
    @Override public void run() { ReimbursementCase.main(new String[0]); }
}