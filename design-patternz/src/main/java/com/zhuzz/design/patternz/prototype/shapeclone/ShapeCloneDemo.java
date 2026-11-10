package com.zhuzz.design.patternz.prototype.shapeclone;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ShapeCloneDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_PROTOTYPE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Shape Clone", Locale.SIMPLIFIED_CHINESE, "图形克隆");
    }
    @Override public void run() {
        // 创建原型对象
        Shape circle = new Shape("Circle");

        // 克隆原型对象来创建新对象
        Shape clonedCircle = circle.clone();
        clonedCircle.setType("Cloned Circle");

        // 输出原型对象和克隆对象的类型
        System.out.println("Original Shape Type: " + circle.getType());
        System.out.println("Cloned Shape Type: " + clonedCircle.getType());
    }
}