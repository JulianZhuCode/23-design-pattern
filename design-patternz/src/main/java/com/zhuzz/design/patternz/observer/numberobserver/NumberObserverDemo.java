package com.zhuzz.design.patternz.observer.numberobserver;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 观察者模式演示：数字变化时通知观察者
 * Observer demo: notify on number change
 */
public class NumberObserverDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_OBSERVER; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Number Observer", Locale.SIMPLIFIED_CHINESE, "数字观察");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(new PlaygroundInput(
                "number",
                Map.of(Locale.ENGLISH, "Number", Locale.SIMPLIFIED_CHINESE, "数字"),
                PlaygroundInput.Type.TEXT,
                List.of(),
                "10"));
    }

    @Override public void run(Map<String, String> values) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("观察者1");
        Observer observer2 = new ConcreteObserver("观察者2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // 按用户输入的数字更新状态，观察观察者如何收到通知
        // set the user-provided number and see observers get notified
        int number = Integer.parseInt(values.getOrDefault("number", "10"));
        subject.setState(number);
    }
}