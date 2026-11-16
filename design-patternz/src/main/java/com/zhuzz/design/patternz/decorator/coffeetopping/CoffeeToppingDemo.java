package com.zhuzz.design.patternz.decorator.coffeetopping;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 装饰者模式演示：动态给咖啡加料
 * Decorator demo: add toppings dynamically
 */
public class CoffeeToppingDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_DECORATOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Coffee Topping", Locale.SIMPLIFIED_CHINESE, "咖啡加料");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of(
                new PlaygroundInput(
                        "milk",
                        Map.of(Locale.ENGLISH, "Add Milk", Locale.SIMPLIFIED_CHINESE, "加牛奶"),
                        PlaygroundInput.Type.CHOICE,
                        List.of("Yes", "No"),
                        "No"),
                new PlaygroundInput(
                        "sugar",
                        Map.of(Locale.ENGLISH, "Add Sugar", Locale.SIMPLIFIED_CHINESE, "加糖"),
                        PlaygroundInput.Type.CHOICE,
                        List.of("Yes", "No"),
                        "No"));
    }

    @Override public void run(Map<String, String> values) {
        // 按用户选择动态叠加装饰器，观察价格与描述的累加
        // stack decorators based on user choices to see cost and description accumulate
        Coffee coffee = new SimpleCoffee();
        if ("Yes".equals(values.getOrDefault("milk", "No"))) {
            coffee = new MilkDecorator(coffee);
        }
        if ("Yes".equals(values.getOrDefault("sugar", "No"))) {
            coffee = new SugarDecorator(coffee);
        }
        Messages.println("coffeeTopping.result", coffee.cost(), coffee.description());
    }
}