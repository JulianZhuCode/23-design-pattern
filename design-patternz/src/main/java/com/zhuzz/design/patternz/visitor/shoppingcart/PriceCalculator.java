package com.zhuzz.design.patternz.visitor.shoppingcart;

/**
 * 具体访问者：计算购物车总价
 * Concrete visitor: computes total price
 */
public class PriceCalculator implements ShoppingItemVisitor {
    private double total;

    @Override
    public void visit(Book book) {
        total += book.getPrice();
        System.out.println("Book: " + book.getName() + " = " + book.getPrice());
    }

    @Override
    public void visit(Electronics electronics) {
        total += electronics.getPrice();
        System.out.println("Electronics: " + electronics.getName() + " = " + electronics.getPrice());
    }

    public double getTotal() {
        return total;
    }
}