package com.zhuzz.design.patternz.iterator.collection;

/** 可迭代集合接口：创建对应的迭代器 */
public interface IterableCollection<T> {
    Iterator<T> createIterator();
}