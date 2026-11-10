package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

/** Mac 组件族：按钮 */
public class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("[Mac] Button clicked");
    }
}