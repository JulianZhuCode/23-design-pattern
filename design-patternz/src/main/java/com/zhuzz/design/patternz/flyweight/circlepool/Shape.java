package com.zhuzz.design.patternz.flyweight.circlepool;

/** 享元接口：图形，绘制时传入外部坐标 */
public interface Shape {
    void draw(int x, int y);
}