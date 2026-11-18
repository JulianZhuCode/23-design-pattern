package com.zhuzz.design.patternz.prototype.shapeclone;

import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ShapeCloneDemo extends DemoSupport {
    @Override public I18nMessages pattern() { return PAT_PROTOTYPE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Shape Clone", Locale.SIMPLIFIED_CHINESE, "图形克隆");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        // 创建原型对象
        // Create the prototype
        Shape circle = new Shape("Circle");

        // 克隆原型创建新对象
        // Clone the prototype
        Shape clonedCircle = circle.clone();
        clonedCircle.setType("Cloned Circle");

        // 输出原型与克隆的类型
        // Print original and cloned types
        Messages.println("shape.original", circle.getType());
        Messages.println("shape.cloned", clonedCircle.getType());
    }
}