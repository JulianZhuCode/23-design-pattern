package com.zhuzz.design.patternz.observer.numberobserver;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 观察者模式演示：数字变化时通知观察者
 * Observer demo: notify on number change
 */
public class NumberObserverDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_OBSERVER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Number Observer", Locale.SIMPLIFIED_CHINESE, "数字观察");
    }
    @Override public void run() {
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
}