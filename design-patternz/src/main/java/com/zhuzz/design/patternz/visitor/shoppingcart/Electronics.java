package com.zhuzz.design.patternz.visitor.shoppingcart;

/**
 * 具体元素：电子产品
 * Concrete element: electronics
 */
public class Electronics implements ShoppingItem {
    private final String name;
    private final double price;

    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(ShoppingItemVisitor visitor) {
        visitor.visit(this);
    }
}