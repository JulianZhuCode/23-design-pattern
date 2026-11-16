package com.zhuzz.design.patternz.iterator.playlist;

import java.util.List;

/**
 * 具体迭代器：逆序遍历
 * Concrete iterator: reverse traversal
 */
public class ReverseSongIterator implements SongIterator {
    private final List<Song> songs;
    private int position;

    public ReverseSongIterator(List<Song> songs) {
        this.songs = songs;
        this.position = songs.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public Song next() {
        if (hasNext()) {
            Song song = songs.get(position);
            position--;
            return song;
        }
        throw new IndexOutOfBoundsException("No more songs");
    }
}