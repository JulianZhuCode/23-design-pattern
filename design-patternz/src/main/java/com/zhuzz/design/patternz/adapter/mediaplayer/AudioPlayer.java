package com.zhuzz.design.patternz.adapter.mediaplayer;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 客户端使用的播放器：原生支持 MP3，其余格式交给适配器
 * Client player: plays MP3 natively, delegates other formats to the adapter
 */
public class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            Messages.println("audioPlayer.playMp3", fileName);
        } else if ("vlc".equalsIgnoreCase(audioType) || "mp4".equalsIgnoreCase(audioType)) {
            MediaAdapter adapter = new MediaAdapter(audioType);
            adapter.play(audioType, fileName);
        } else {
            Messages.println("audioPlayer.invalid", audioType);
        }
    }
}