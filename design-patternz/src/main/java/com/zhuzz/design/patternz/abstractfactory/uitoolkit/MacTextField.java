package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * Mac 组件：文本框
 * Mac widget: text field
 */
public class MacTextField implements TextField {
    @Override
    public void input(String text) {
        Messages.println("mac.textfield.input", text);
    }
}