package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

/**
 * Mac 组件：按钮
 * Mac widget: button
 */
public class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("[Mac] Button clicked");
    }
}