package com.zhuzz.design.patternz.templatemethod.dataprocessor;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体类：JSON 数据处理流程
 * Concrete class: JSON data processing
 */
public class JsonDataProcessor extends DataProcessor {

    @Override
    protected String readData() {
        return "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":25}]";
    }

    @Override
    protected String parseData(String rawData) {
        int items = rawData.split("\\{").length - 1;
        return Messages.get("dataprocessor.jsonParsed", items);
    }

    @Override
    protected void saveData(String parsedData) {
        Messages.println("dataprocessor.jsonSave", parsedData);
    }
}