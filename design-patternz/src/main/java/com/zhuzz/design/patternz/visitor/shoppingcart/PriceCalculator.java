package com.zhuzz.design.patternz.visitor.shoppingcart;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体访问者：计算购物车总价
 * Concrete visitor: computes total price
 */
public class PriceCalculator implements ShoppingItemVisitor {
    private double total;

    @Override
    public void visit(Book book) {
        total += book.getPrice();
        Messages.println("cart.book", book.getName(), book.getPrice());
    }

    @Override
    public void visit(Electronics electronics) {
        total += electronics.getPrice();
        Messages.println("cart.electronics", electronics.getName(), electronics.getPrice());
    }

    public double getTotal() {
        return total;
    }
}