package com.zhuzz.design.patternz.bridge.shapecolor;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体实现：红色
 * Concrete implementor: red
 */
public class Red implements Color {
    @Override
    public void applyColor() {
        Messages.println("red.applying");
    }
}