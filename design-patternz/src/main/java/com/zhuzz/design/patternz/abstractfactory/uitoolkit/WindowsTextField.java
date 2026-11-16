package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * Windows 组件：文本框
 * Windows widget: text field
 */
public class WindowsTextField implements TextField {
    @Override
    public void input(String text) {
        Messages.println("windows.textfield.input", text);
    }
}