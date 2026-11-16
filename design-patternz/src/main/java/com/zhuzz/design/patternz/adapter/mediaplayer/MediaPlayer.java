package com.zhuzz.design.patternz.adapter.mediaplayer;

/**
 * 目标接口：客户端期望的播放接口
 * Target: playback interface expected by client
 */
public interface MediaPlayer {
    void play(String audioType, String fileName);
}