package com.zhuzz.design.patternz.decorator;

/**
 * 装饰模式 - 咖啡加料案例
 *
 * @author zhuzz
 * 2023/8/29 17:38
 */
public class CoffeeDecoratorCase {

    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Cost: $" + simpleCoffee.cost() + ", Description: " + simpleCoffee.description());

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Cost: $" + milkCoffee.cost() + ", Description: " + milkCoffee.description());

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: $" + sugarMilkCoffee.cost() + ", Description: " + sugarMilkCoffee.description());
    }

    interface Coffee {
        double cost();

        String description();
    }

    static class SimpleCoffee implements Coffee {
        @Override
        public double cost() {
            return 2.0;
        }

        @Override
        public String description() {
            return "Simple Coffee";
        }
    }

    static abstract class CoffeeDecorator implements Coffee {
        protected Coffee decoratedCoffee;

        public CoffeeDecorator(Coffee coffee) {
            this.decoratedCoffee = coffee;
        }

        @Override
        public double cost() {
            return decoratedCoffee.cost();
        }

        @Override
        public String description() {
            return decoratedCoffee.description();
        }
    }

    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public double cost() {
            return super.cost() + 1.0;
        }

        @Override
        public String description() {
            return super.description() + ", with Milk";
        }
    }

    static class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public double cost() {
            return super.cost() + 0.5;
        }

        @Override
        public String description() {
            return super.description() + ", with Sugar";
        }
    }

}