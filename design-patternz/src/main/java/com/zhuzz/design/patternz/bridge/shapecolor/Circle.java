package com.zhuzz.design.patternz.bridge.shapecolor;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 扩展抽象化：圆形
 * Refined abstraction: circle
 */
public class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        Messages.print("circle.drawing");
        color.applyColor();
    }
}