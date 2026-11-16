package com.zhuzz.design.patternz.adapter.mediaplayer;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class MediaPlayerDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_ADAPTER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Media Player", Locale.SIMPLIFIED_CHINESE, "媒体播放器");
    }
    @Override public void run() {
        AudioPlayer audioPlayer = new AudioPlayer();

        // 原生支持的格式
        // natively supported format
        audioPlayer.play("mp3", "song.mp3");

        // 通过适配器播放的高级格式
        // advanced formats played through the adapter
        audioPlayer.play("vlc", "movie.vlc");
        audioPlayer.play("mp4", "clip.mp4");

        // 不支持的格式
        // unsupported format
        audioPlayer.play("avi", "unsupported.avi");
    }
}