package com.zhuzz.design.patternz.adapter.rectangleadapter;

/** 目标接口：客户端期望使用的图形绘制接口 */
public interface Shape {
    void draw(int x, int y, int width, int height);
}