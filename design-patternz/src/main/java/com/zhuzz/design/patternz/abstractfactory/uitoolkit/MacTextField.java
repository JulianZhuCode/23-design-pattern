package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

/** Mac 组件族：文本框 */
public class MacTextField implements TextField {
    @Override
    public void input(String text) {
        System.out.println("[Mac] TextField input: " + text);
    }
}