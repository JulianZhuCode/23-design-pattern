package com.zhuzz.design.patternz.prototype.resumeclone;

import com.zhuzz.design.lab.DemoSupport;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;
import com.zhuzz.design.lab.i18n.Messages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class ResumeCloneDemo extends DemoSupport {
    @Override public I18nMessages pattern() { return PAT_PROTOTYPE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Resume Clone", Locale.SIMPLIFIED_CHINESE, "简历克隆");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        // 创建原型简历
        // Create the prototype
        Resume prototype = new Resume("Alice", new WorkExperience("Acme", "2020-2023"));

        // 克隆简历并修改副本，验证深拷贝互不影响
        // Clone and modify the copy; deep copy keeps the original untouched
        Resume copy = prototype.clone();
        copy.setName("Bob");
        copy.getExperience().setCompany("Globex");

        Messages.println("resume.prototype", prototype);
        Messages.println("resume.copy", copy);
    }
}