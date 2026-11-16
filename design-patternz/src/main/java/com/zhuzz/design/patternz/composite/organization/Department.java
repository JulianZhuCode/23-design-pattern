package com.zhuzz.design.patternz.composite.organization;

import com.zhuzz.design.lab.i18n.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器节点：部门，可包含员工和子部门
 * Composite: department holding children
 */
public class Department implements OrgComponent {
    private String name;
    private List<OrgComponent> components;

    public Department(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public void add(OrgComponent component) {
        components.add(component);
    }

    @Override
    public void display() {
        Messages.println("org.department", name);
        for (OrgComponent component : components) {
            component.display();
        }
    }
}