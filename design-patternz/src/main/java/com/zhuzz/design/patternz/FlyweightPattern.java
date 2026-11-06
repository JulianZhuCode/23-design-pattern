package com.zhuzz.design.patternz;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 *
 * @author zhuzz
 * 2023/8/29 17:41
 */
public class FlyweightPattern {
    enum Color { RED, GREEN, BLUE, YELLOW }
    public static void main(String[] args) {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

        for (int i = 0; i < 20; i++) {
            Color randomColor = colors[(int) (Math.random() * colors.length)];
            Shape circle = ShapeFactory.getCircle(randomColor);
            circle.draw((int) (Math.random() * 100), (int) (Math.random() * 100));

        }
    }

    interface Shape {
        void draw(int x, int y);
    }

    static class Circle implements Shape {
        private final Color color;

        public Circle(Color color) {
            this.color = color;
        }

        @Override
        public void draw(int x, int y) {
            System.out.println("Drawing a " + color + " circle at (" + x + "," + y + ")");
        }
    }

    static class ShapeFactory {
        private static final Map<Color, Shape> circleMap = new HashMap<>();

        public static Shape getCircle(Color color) {

            return circleMap.computeIfAbsent(color, Circle::new);
        }
    }

}
