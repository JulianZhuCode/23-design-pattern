package com.zhuzz.design.patternz.visitor.shoppingcart;

/**
 * 具体元素：书籍
 * Concrete element: book
 */
public class Book implements ShoppingItem {
    private final String name;
    private final double price;

    public Book(String name, double price) {
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