package com.zhuzz.design.patternz.bridge.shapecolor;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 扩展抽象化：正方形
 * Refined abstraction: square
 */
public class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        Messages.print("square.drawing");
        color.applyColor();
    }
}