package com.zhuzz.design.patternz.abstractfactory.uitoolkit;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * Mac 组件：按钮
 * Mac widget: button
 */
public class MacButton implements Button {
    @Override
    public void click() {
        Messages.println("mac.button.clicked");
    }
}