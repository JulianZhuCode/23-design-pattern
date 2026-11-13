package com.zhuzz.design.patternz.chainofresponsibility.reimbursement;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 责任链模式演示：报销按金额分级审批
 * Chain of Responsibility demo: tiered approval by amount
 */
public class ReimbursementDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_CHAIN_OF_RESPONSIBILITY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Reimbursement", Locale.SIMPLIFIED_CHINESE, "报销审批");
    }
    @Override public void run() {
        ReimbursementHandler departmentHead = new DepartmentHeadHandler();
        ReimbursementHandler manager = new ManagerHandler();
        ReimbursementHandler finance = new FinanceHandler();

        departmentHead.setSuccessor(manager);
        manager.setSuccessor(finance);

        ReimbursementRequest request1 = new ReimbursementRequest(800, "购买办公用品");
        ReimbursementRequest request2 = new ReimbursementRequest(3000, "参加培训");
        ReimbursementRequest request3 = new ReimbursementRequest(10000, "举办团建活动");

        departmentHead.handleRequest(request1);
        departmentHead.handleRequest(request2);
        departmentHead.handleRequest(request3);
    }
}