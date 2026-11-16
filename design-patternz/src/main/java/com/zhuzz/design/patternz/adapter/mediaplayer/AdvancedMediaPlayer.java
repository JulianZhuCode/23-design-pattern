package com.zhuzz.design.patternz.adapter.mediaplayer;

/**
 * 被适配接口：高级播放器支持多种格式
 * Adaptee interface: advanced player supports multiple formats
 */
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);

    void playMp4(String fileName);
}