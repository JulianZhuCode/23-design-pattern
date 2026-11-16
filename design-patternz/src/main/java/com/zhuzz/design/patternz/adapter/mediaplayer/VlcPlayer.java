package com.zhuzz.design.patternz.adapter.mediaplayer;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 被适配者：VLC 播放器
 * Adaptee: VLC player
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        Messages.println("vlcPlayer.play", fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // VLC 不支持 MP4
        // VLC does not support MP4
    }
}