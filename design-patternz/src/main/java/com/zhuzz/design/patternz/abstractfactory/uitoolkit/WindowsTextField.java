package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

/**
 * Windows 组件：文本框
 * Windows widget: text field
 */
public class WindowsTextField implements TextField {
    @Override
    public void input(String text) {
        System.out.println("[Windows] TextField input: " + text);
    }
}