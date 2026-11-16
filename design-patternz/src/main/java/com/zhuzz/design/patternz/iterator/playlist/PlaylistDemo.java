package com.zhuzz.design.patternz.iterator.playlist;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class PlaylistDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_ITERATOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Playlist", Locale.SIMPLIFIED_CHINESE, "播放列表");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        Playlist playlist = new Playlist();
        playlist.addSong(new Song("Song A", "Artist 1"));
        playlist.addSong(new Song("Song B", "Artist 2"));
        playlist.addSong(new Song("Song C", "Artist 3"));

        // 顺序遍历
        // forward traversal
        System.out.println("Forward:");
        SongIterator forward = playlist.createIterator();
        while (forward.hasNext()) {
            System.out.println(forward.next());
        }

        // 逆序遍历
        // reverse traversal
        System.out.println("Reverse:");
        SongIterator reverse = playlist.createReverseIterator();
        while (reverse.hasNext()) {
            System.out.println(reverse.next());
        }
    }
}