package com.zhuzz.design.patternz.iterator.collection;

/**
 * 迭代器接口：提供顺序访问能力
 * Iterator: sequential access
 */
public interface Iterator<T> {
    boolean hasNext();

    T next();
}