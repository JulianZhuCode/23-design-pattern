package com.zhuzz.design.patternz.memento;

/**
 * 备忘录模式 - 文本编辑器案例
 *
 * @author zhuzz
 * 2023/8/29 17:51
 */
public class TextEditorCase {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // 设置初始状态
        originator.setState("State 1");
        System.out.println("Current State: " + originator.getState());

        // 创建备忘录并保存状态
        caretaker.setMemento(originator.createMemento());

        // 修改状态
        originator.setState("State 2");
        System.out.println("Updated State: " + originator.getState());

        // 恢复之前的状态
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("Restored State: " + originator.getState());
    }

    static class Memento {
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }


    static class Originator {
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


    static class Caretaker {
        private Memento memento;

        public Memento getMemento() {
            return memento;
        }

        public void setMemento(Memento memento) {
            this.memento = memento;
        }
    }

}