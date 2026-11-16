package com.zhuzz.design.patternz.memento.gamesave;

/**
 * 备忘录：保存某一时刻的游戏状态快照
 * Memento: stores a game-state snapshot
 */
public class GameState {
    private final int level;
    private final int score;

    public GameState(int level, int score) {
        this.level = level;
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }
}