package com.zhuzz.design.patternz.templatemethod.dataprocessor;

/**
 * 抽象类：定义数据处理流程的算法骨架（模板方法）。
 * Abstract class: defines the algorithm skeleton (template method).
 */
public abstract class DataProcessor {

    /** 模板方法：固定算法骨架，final 禁止子类重写 | Template method: fixes the skeleton, final prevents override */
    public final void process() {
        String rawData = readData();
        String parsedData = parseData(rawData);
        saveData(parsedData);
    }

    /** 基本方法：读取原始数据 | Primitive step: read raw data */
    protected abstract String readData();

    /** 基本方法：解析数据 | Primitive step: parse data */
    protected abstract String parseData(String rawData);

    /** 基本方法：保存结果 | Primitive step: save result */
    protected abstract void saveData(String parsedData);
}