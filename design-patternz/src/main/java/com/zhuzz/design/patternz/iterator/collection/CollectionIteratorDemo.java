package com.zhuzz.design.patternz.iterator.collection;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/** 迭代器模式演示：不暴露内部结构地遍历集合 | Iterator demo: traverse without exposing internals */
public class CollectionIteratorDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_ITERATOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Collection Iterator", Locale.SIMPLIFIED_CHINESE, "集合遍历");
    }
    @Override public void run() {
        ConcreteCollection<String> collection = new ConcreteCollection<>();
        collection.addItem("Item 1");
        collection.addItem("Item 2");
        collection.addItem("Item 3");

        Iterator<String> iterator = collection.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}