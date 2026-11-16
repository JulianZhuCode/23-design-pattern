package com.zhuzz.design.patternz.flyweight.circlepool;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体享元：圆形，颜色为共享的内部状态
 * Concrete flyweight: circle with shared color
 */
public class Circle implements Shape {
    private final Color color;

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        Messages.println("circle.draw", color, x, y);
    }
}