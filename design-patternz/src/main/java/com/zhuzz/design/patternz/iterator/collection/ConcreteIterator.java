package com.zhuzz.design.patternz.iterator.collection;

import java.util.List;

/** 具体迭代器：跟踪当前位置，顺序返回元素 */
public class ConcreteIterator<T> implements Iterator<T> {
    private final List<T> items;
    private int position = 0;

    public ConcreteIterator(List<T> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            T item = items.get(position);
            position++;
            return item;
        }
        throw new IndexOutOfBoundsException("No more elements");
    }
}