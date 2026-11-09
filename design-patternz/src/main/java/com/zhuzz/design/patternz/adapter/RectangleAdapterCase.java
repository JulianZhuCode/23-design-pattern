package com.zhuzz.design.patternz.adapter;

/**
 * 适配器模式 - 矩形适配案例
 *
 * @author zhuzz
 * 2023/8/29 17:35
 */
public class RectangleAdapterCase {

    public static void main(String[] args) {
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        Shape shapeAdapter = new RectangleAdapter(legacyRectangle);

        shapeAdapter.draw(10, 20, 50, 30);
    }

    static class LegacyRectangle {
        public void display(int x1, int y1, int x2, int y2) {
            System.out.println("LegacyRectangle: Point1(" + x1 + ", " + y1 + "), Point2(" + x2 + ", " + y2 + ")");
        }
    }

    interface Shape {
        void draw(int x, int y, int width, int height);
    }

    static class RectangleAdapter implements Shape {
        private LegacyRectangle legacyRectangle;

        public RectangleAdapter(LegacyRectangle legacyRectangle) {
            this.legacyRectangle = legacyRectangle;
        }

        @Override
        public void draw(int x, int y, int width, int height) {
            int x1 = x;
            int y1 = y;
            int x2 = x + width;
            int y2 = y + height;
            legacyRectangle.display(x1, y1, x2, y2);
        }
    }

}