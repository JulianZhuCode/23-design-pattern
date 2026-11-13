package com.zhuzz.design.patternz.observer.numberobserver;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 具体主题：维护观察者列表，状态变化时通知所有观察者
 * Concrete subject: notifies observers on change
 */
public class ConcreteSubject implements Subject {
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}