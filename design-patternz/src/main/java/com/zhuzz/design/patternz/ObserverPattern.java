package com.zhuzz.design.patternz;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 观察者模式
 *
 * @author zhuzz
 * 2023/8/29 17:53
 */
public class ObserverPattern {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("观察者1");
        Observer observer2 = new ConcreteObserver("观察者2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.setState(10);
        subject.setState(20);

        subject.removeObserver(observer1);

        subject.setState(30);
    }

    interface Subject {
        void addObserver(Observer observer);

        void removeObserver(Observer observer);

        void notifyObservers();
    }


    static class ConcreteSubject implements Subject {
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


    interface Observer {
        void update(int state);
    }


    static class ConcreteObserver implements Observer {
        private final String name;

        public ConcreteObserver(String name) {
            this.name = name;
        }

        @Override
        public void update(int state) {
            System.out.println(name + " 收到更新，新状态为: " + state);
        }
    }


}