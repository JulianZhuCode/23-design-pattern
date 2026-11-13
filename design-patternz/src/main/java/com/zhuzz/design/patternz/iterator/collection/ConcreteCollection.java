package com.zhuzz.design.patternz.iterator.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体集合：内部用 List 存储元素
 * Concrete collection: backed by a List
 */
public class ConcreteCollection<T> implements IterableCollection<T> {
    private final List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    @Override
    public Iterator<T> createIterator() {
        return new ConcreteIterator<>(items);
    }
}