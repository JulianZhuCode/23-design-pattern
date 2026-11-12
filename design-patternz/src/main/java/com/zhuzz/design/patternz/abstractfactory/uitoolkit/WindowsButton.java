package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

/** Windows 组件：按钮 | Windows widget: button */
public class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("[Windows] Button clicked");
    }
}