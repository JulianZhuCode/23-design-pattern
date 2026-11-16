package com.zhuzz.design.patternz.templatemethod.beverage;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 抽象类：定义饮品的制作骨架（模板方法）
 * Abstract class: defines the beverage-making skeleton
 */
public abstract class Beverage {

    /**
     * 模板方法：固定制作流程，final 禁止子类重写
     * Template method: fixes the steps, final prevents override
     */
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
     * 基本方法：烧水（共用实现）
     * Primitive step: boil water (shared)
     */
    protected void boilWater() {
        Messages.println("beverage.boilingWater");
    }

    /**
     * 基本方法：冲泡（子类实现）
     * Primitive step: brew (subclass)
     */
    protected abstract void brew();

    /**
     * 基本方法：倒入杯中（共用实现）
     * Primitive step: pour into cup (shared)
     */
    protected void pourInCup() {
        Messages.println("beverage.pouringIntoUp");
    }

    /**
     * 基本方法：加调料（子类实现）
     * Primitive step: add condiments (subclass)
     */
    protected abstract void addCondiments();

    /**
     * 钩子方法：是否加调料，默认加
     * Hook: whether to add condiments, default true
     */
    protected boolean customerWantsCondiments() {
        return true;
    }
}