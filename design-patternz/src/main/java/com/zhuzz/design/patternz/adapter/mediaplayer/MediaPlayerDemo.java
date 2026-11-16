package com.zhuzz.design.patternz.adapter.mediaplayer;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class MediaPlayerDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_ADAPTER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Media Player", Locale.SIMPLIFIED_CHINESE, "媒体播放器");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "format",
                Map.of(Locale.ENGLISH, "Format", Locale.SIMPLIFIED_CHINESE, "音频格式"),
                PlaygroundInput.Type.CHOICE,
                List.of("mp3", "vlc", "mp4", "avi"),
                "mp3"));
    }

    @Override public void run(Map<String, String> values) {
        AudioPlayer audioPlayer = new AudioPlayer();

        // 按用户选择的格式播放，观察适配器如何兜底高级格式
        // play the user-selected format to see how the adapter handles advanced formats
        String format = values.getOrDefault("format", "mp3");
        audioPlayer.play(format, "sample." + format);
    }
}