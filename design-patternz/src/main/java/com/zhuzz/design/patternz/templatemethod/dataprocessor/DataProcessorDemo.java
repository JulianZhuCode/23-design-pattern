package com.zhuzz.design.patternz.templatemethod.dataprocessor;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class DataProcessorDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_TEMPLATE_METHOD; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Data Processor", Locale.SIMPLIFIED_CHINESE, "数据处理");
    }
    @Override public void run() {
        AbstractClass template = new ConcreteClass();
        template.templateMethod();
    }
}