package com.zhuzz.design.patternz.composite.organization;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class OrganizationDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_COMPOSITE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Organization", Locale.SIMPLIFIED_CHINESE, "组织架构");
    }
    @Override public void run() {
        // 创建员工与部门
        // create employees and departments
        Employee alice = new Employee("Alice", "Engineer");
        Employee bob = new Employee("Bob", "Designer");
        Department engineering = new Department("Engineering");
        engineering.add(alice);
        engineering.add(bob);

        Employee carol = new Employee("Carol", "Accountant");
        Department finance = new Department("Finance");
        finance.add(carol);

        Department company = new Department("Company");
        company.add(engineering);
        company.add(finance);

        // 展示组织架构
        // display the structure
        company.display();
    }
}