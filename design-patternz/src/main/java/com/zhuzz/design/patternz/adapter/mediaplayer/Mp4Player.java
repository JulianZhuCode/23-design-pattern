package com.zhuzz.design.patternz.adapter.mediaplayer;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 被适配者：MP4 播放器
 * Adaptee: MP4 player
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // MP4 播放器不支持 VLC
        // MP4 player does not support VLC
    }

    @Override
    public void playMp4(String fileName) {
        Messages.println("mp4Player.play", fileName);
    }
}