package com.zhuzz.design.patternz.iterator.playlist;

import java.util.List;

/**
 * 具体迭代器：顺序遍历
 * Concrete iterator: forward traversal
 */
public class SequentialSongIterator implements SongIterator {
    private final List<Song> songs;
    private int position = 0;

    public SequentialSongIterator(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public boolean hasNext() {
        return position < songs.size();
    }

    @Override
    public Song next() {
        if (hasNext()) {
            Song song = songs.get(position);
            position++;
            return song;
        }
        throw new IndexOutOfBoundsException("No more songs");
    }
}