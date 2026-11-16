package com.zhuzz.design.patternz.bridge.shapecolor;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体实现：蓝色
 * Concrete implementor: blue
 */
public class Blue implements Color {
    @Override
    public void applyColor() {
        Messages.println("blue.applying");
    }
}