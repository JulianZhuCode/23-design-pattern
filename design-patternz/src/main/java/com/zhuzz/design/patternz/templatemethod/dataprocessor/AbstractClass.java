package com.zhuzz.design.patternz.templatemethod.dataprocessor;

/** 抽象类：定义模板方法（算法骨架），具体步骤交由子类实现 */
public abstract class AbstractClass {

    /** 模板方法，定义算法的骨架（final 防止子类重写） */
    public final void templateMethod() {
        step1();
        step2();
        step3();
    }

    /** 基本方法，子类需要实现 */
    protected abstract void step1();

    /** 基本方法，子类需要实现 */
    protected abstract void step2();

    /** 基本方法，子类需要实现 */
    protected abstract void step3();
}