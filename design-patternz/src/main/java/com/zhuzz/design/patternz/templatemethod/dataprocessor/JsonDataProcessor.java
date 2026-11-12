package com.zhuzz.design.patternz.templatemethod.dataprocessor;

/** 具体类：JSON 数据处理流程，复用同一骨架、替换各步骤实现 */
public class JsonDataProcessor extends DataProcessor {

    @Override
    protected String readData() {
        return "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":25}]";
    }

    @Override
    protected String parseData(String rawData) {
        int items = rawData.split("\\{").length - 1;
        return items + " records parsed from JSON";
    }

    @Override
    protected void saveData(String parsedData) {
        System.out.println("[JSON] Saving result: " + parsedData);
    }
}