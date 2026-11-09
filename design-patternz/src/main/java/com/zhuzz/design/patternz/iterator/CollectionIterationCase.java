package com.zhuzz.design.patternz.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式 - 集合迭代案例
 *
 * @author zhuzz
 * 2023/8/29 17:49
 */
public class CollectionIterationCase {

    public static void main(String[] args) {
        ConcreteCollection<String> collection = new ConcreteCollection<>();
        collection.addItem("Item 1");
        collection.addItem("Item 2");
        collection.addItem("Item 3");

        Iterator<String> iterator = collection.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    interface IterableCollection<T> {
        Iterator<T> createIterator();
    }

    static class ConcreteCollection<T> implements IterableCollection<T> {
        private List<T> items = new ArrayList<>();

        public void addItem(T item) {
            items.add(item);
        }

        @Override
        public Iterator<T> createIterator() {
            return new ConcreteIterator<>(items);
        }
    }

    interface Iterator<T> {
        boolean hasNext();

        T next();
    }

    static class ConcreteIterator<T> implements Iterator<T> {
        private List<T> items;
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


}