package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * Windows 组件：按钮
 * Windows widget: button
 */
public class WindowsButton implements Button {
    @Override
    public void click() {
        Messages.println("windows.button.clicked");
    }
}