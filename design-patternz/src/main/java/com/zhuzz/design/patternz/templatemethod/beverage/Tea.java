package com.zhuzz.design.patternz.templatemethod.beverage;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体类：茶
 * Concrete class: tea
 */
public class Tea extends Beverage {

    @Override
    protected void brew() {
        Messages.println("beverage.steepingTea");
    }

    @Override
    protected void addCondiments() {
        Messages.println("beverage.addingLemon");
    }
}