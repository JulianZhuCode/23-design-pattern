package com.zhuzz.design.patternz.memento.texteditor;

/** 负责人：保管备忘录，但不修改其内容 | Caretaker: keeps mementos without modifying */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}