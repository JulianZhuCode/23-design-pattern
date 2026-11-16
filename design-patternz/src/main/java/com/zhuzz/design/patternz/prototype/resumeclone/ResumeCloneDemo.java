package com.zhuzz.design.patternz.prototype.resumeclone;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ResumeCloneDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_PROTOTYPE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Resume Clone", Locale.SIMPLIFIED_CHINESE, "简历克隆");
    }
    @Override public void run() {
        // 创建原型简历
        // Create the prototype
        Resume prototype = new Resume("Alice", new WorkExperience("Acme", "2020-2023"));

        // 克隆简历并修改副本，验证深拷贝互不影响
        // Clone and modify the copy; deep copy keeps the original untouched
        Resume copy = prototype.clone();
        copy.setName("Bob");
        copy.getExperience().setCompany("Globex");

        System.out.println("Prototype: " + prototype);
        System.out.println("Copy:      " + copy);
    }
}