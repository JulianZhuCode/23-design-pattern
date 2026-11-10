package com.zhuzz.design.patternz.adapter.rectangleadapter;

/** 适配者（被适配的旧类）：以两点坐标方式绘制矩形 */
public class LegacyRectangle {
    public void display(int x1, int y1, int x2, int y2) {
        System.out.println("LegacyRectangle: Point1(" + x1 + ", " + y1 + "), Point2(" + x2 + ", " + y2 + ")");
    }
}