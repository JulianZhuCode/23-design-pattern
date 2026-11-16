package com.zhuzz.design.patternz.chainofresponsibility.reimbursement;

import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 责任链模式演示：报销按金额分级审批
 * Chain of Responsibility demo: tiered approval by amount
 */
public class ReimbursementDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_CHAIN_OF_RESPONSIBILITY; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Reimbursement", Locale.SIMPLIFIED_CHINESE, "报销审批");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "amount",
                Map.of(Locale.ENGLISH, "Amount", Locale.SIMPLIFIED_CHINESE, "报销金额"),
                PlaygroundInput.Type.TEXT,
                List.of(),
                "800"));
    }

    @Override public void run(Map<String, String> values) {
        ReimbursementHandler departmentHead = new DepartmentHeadHandler();
        ReimbursementHandler manager = new ManagerHandler();
        ReimbursementHandler finance = new FinanceHandler();

        departmentHead.setSuccessor(manager);
        manager.setSuccessor(finance);

        // 按用户输入的金额构造一条报销请求，观察审批链的流转
        // build a request from the user-provided amount to observe the chain flow
        double amount = Double.parseDouble(values.getOrDefault("amount", "800"));
        ReimbursementRequest request = new ReimbursementRequest(amount, "沙盒报销申请");
        departmentHead.handleRequest(request);
    }
}