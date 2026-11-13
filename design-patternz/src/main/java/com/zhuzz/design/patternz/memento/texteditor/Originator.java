package com.zhuzz.design.patternz.memento.texteditor;

/**
 * 发起者：保存当前状态到备忘录，或从备忘录恢复状态
 * Originator: saves/restores state via memento
 */
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento memento) {
        state = memento.getState();
    }
}