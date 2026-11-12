package com.zhuzz.design.patternz.templatemethod.dataprocessor;

/** 具体类：CSV 数据处理流程，复用同一骨架、仅实现各可变步骤 */
public class CsvDataProcessor extends DataProcessor {

    @Override
    protected String readData() {
        return "name,age\nAlice,30\nBob,25";
    }

    @Override
    protected String parseData(String rawData) {
        int rows = rawData.split("\n").length - 1;
        return rows + " records parsed from CSV";
    }

    @Override
    protected void saveData(String parsedData) {
        System.out.println("[CSV] Saving result: " + parsedData);
    }
}