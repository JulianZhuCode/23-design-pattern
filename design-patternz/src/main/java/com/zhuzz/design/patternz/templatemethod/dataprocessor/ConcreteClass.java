package com.zhuzz.design.patternz.templatemethod.dataprocessor;

/** 具体类：实现模板方法中的各步骤 */
public class ConcreteClass extends AbstractClass {
    @Override
    protected void step1() {
        System.out.println("ConcreteClass: Step 1");
    }

    @Override
    protected void step2() {
        System.out.println("ConcreteClass: Step 2");
    }

    @Override
    protected void step3() {
        System.out.println("ConcreteClass: Step 3");
    }
}