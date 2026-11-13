package com.zhuzz.design.patternz.memento.texteditor;

/**
 * 备忘录：保存某一时刻的状态快照
 * Memento: stores a state snapshot
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}