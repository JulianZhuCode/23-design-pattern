package com.zhuzz.design.patternz.composite.organization;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 叶子节点：员工
 * Leaf: employee
 */
public class Employee implements OrgComponent {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void display() {
        Messages.println("org.employee", name, position);
    }
}