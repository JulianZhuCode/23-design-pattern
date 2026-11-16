package com.zhuzz.design.patternz.visitor.shoppingcart;

/**
 * 访问者接口：为每种具体元素声明访问方法
 * Visitor: declares a method per element
 */
public interface ShoppingItemVisitor {
    void visit(Book book);

    void visit(Electronics electronics);
}