package com.zhuzz.design.patternz.templatemethod.dataprocessor;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体类：CSV 数据处理流程
 * Concrete class: CSV data processing
 */
public class CsvDataProcessor extends DataProcessor {

    @Override
    protected String readData() {
        return "name,age\nAlice,30\nBob,25";
    }

    @Override
    protected String parseData(String rawData) {
        int rows = rawData.split("\n").length - 1;
        return Messages.get("dataprocessor.csvParsed", rows);
    }

    @Override
    protected void saveData(String parsedData) {
        Messages.println("dataprocessor.csvSave", parsedData);
    }
}