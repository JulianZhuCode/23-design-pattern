package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

/** Windows 组件族：按钮 */
public class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("[Windows] Button clicked");
    }
}