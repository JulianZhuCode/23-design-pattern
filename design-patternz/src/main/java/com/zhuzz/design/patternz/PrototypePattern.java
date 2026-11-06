package com.zhuzz.design.patternz;

/**
 * 原型模式
 *
 * @author zhuzz
 * 2023/8/29 17:27
 */
public class PrototypePattern {
    public static void main(String[] args) {
        // 创建原型对象
        Shape circle = new Shape("Circle");

        // 克隆原型对象来创建新对象
        Shape clonedCircle = circle.clone();
        clonedCircle.setType("Cloned Circle");

        // 输出原型对象和克隆对象的类型
        System.out.println("Original Shape Type: " + circle.getType());
        System.out.println("Cloned Shape Type: " + clonedCircle.getType());
    }

    static class Shape implements Cloneable {
        private String type;

        public Shape(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public Shape clone() {
            try {
                return (Shape) super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }
    }
}


