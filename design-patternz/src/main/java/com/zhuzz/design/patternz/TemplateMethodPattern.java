package com.zhuzz.design.patternz;

/**
 * 模板方法模式
 *
 * @author zhuzz
 * 2023/8/29 17:45
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {
        AbstractClass template = new ConcreteClass();
        template.templateMethod();
    }

    static abstract class AbstractClass {
        // 模板方法，定义算法的骨架
        public final void templateMethod() {
            step1();
            step2();
            step3();
        }

        // 基本方法，子类需要实现
        abstract void step1();

        abstract void step2();

        abstract void step3();
    }


    static class ConcreteClass extends AbstractClass {
        @Override
        void step1() {
            System.out.println("ConcreteClass: Step 1");
        }

        @Override
        void step2() {
            System.out.println("ConcreteClass: Step 2");
        }

        @Override
        void step3() {
            System.out.println("ConcreteClass: Step 3");
        }
    }
}
