package com.zhuzz.design.patternz.flyweight.circlepool;

import java.util.HashMap;
import java.util.Map;

/** 享元工厂：按颜色缓存并复用圆形实例 */
public class ShapeFactory {
    private static final Map<Color, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(Color color) {
        return circleMap.computeIfAbsent(color, Circle::new);
    }
}