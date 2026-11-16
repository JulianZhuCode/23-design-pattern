package com.zhuzz.design.patternz.iterator.playlist;

/**
 * 迭代器接口：顺序访问歌曲
 * Iterator: sequential access to songs
 */
public interface SongIterator {
    boolean hasNext();

    Song next();
}