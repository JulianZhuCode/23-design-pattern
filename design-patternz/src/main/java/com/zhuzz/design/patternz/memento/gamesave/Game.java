package com.zhuzz.design.patternz.memento.gamesave;

/**
 * 发起者：游戏，保存当前进度到存档，或从存档恢复
 * Originator: game saving/restoring progress
 */
public class Game {
    private int level;
    private int score;

    public void setState(int level, int score) {
        this.level = level;
        this.score = score;
    }

    public GameState createMemento() {
        return new GameState(level, score);
    }

    public void restoreMemento(GameState memento) {
        this.level = memento.getLevel();
        this.score = memento.getScore();
    }

    @Override
    public String toString() {
        return "Level " + level + ", Score " + score;
    }
}