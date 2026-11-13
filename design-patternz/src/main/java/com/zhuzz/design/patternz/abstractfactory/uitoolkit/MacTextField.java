package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

/**
 * Mac 组件：文本框
 * Mac widget: text field
 */
public class MacTextField implements TextField {
    @Override
    public void input(String text) {
        System.out.println("[Mac] TextField input: " + text);
    }
}