package com.zhuzz.design.patternz.iterator.playlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 聚合对象：播放列表，支持顺序与逆序遍历
 * Aggregate: playlist supporting forward and reverse traversal
 */
public class Playlist {
    private final List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public SongIterator createIterator() {
        return new SequentialSongIterator(songs);
    }

    public SongIterator createReverseIterator() {
        return new ReverseSongIterator(songs);
    }
}