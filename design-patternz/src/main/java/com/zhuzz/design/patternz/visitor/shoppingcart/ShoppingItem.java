package com.zhuzz.design.patternz.visitor.shoppingcart;

/**
 * 元素接口：接受访问者
 * Element: accepts a visitor
 */
public interface ShoppingItem {
    void accept(ShoppingItemVisitor visitor);
}