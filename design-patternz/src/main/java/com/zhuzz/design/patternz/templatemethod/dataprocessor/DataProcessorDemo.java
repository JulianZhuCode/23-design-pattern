package com.zhuzz.design.patternz.templatemethod.dataprocessor;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

/**
 * 模板方法模式演示：复用同一处理骨架
 * Template Method demo: reuse one skeleton
 */
public class DataProcessorDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_TEMPLATE_METHOD; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Data Processor", Locale.SIMPLIFIED_CHINESE, "数据处理");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        DataProcessor csvProcessor = new CsvDataProcessor();
        csvProcessor.process();

        DataProcessor jsonProcessor = new JsonDataProcessor();
        jsonProcessor.process();
    }
}