package com.zhuzz.design.patternz.templatemethod.dataprocessor;

/**
 * 抽象类：定义数据处理流程的算法骨架（模板方法）。
 *
 * <p>骨架由 {@link #process()} 固定为三步：读取原始数据 → 解析数据 → 保存结果，
 * 各步骤由子类实现，从而保证流程顺序稳定、不被子类破坏。</p>
 */
public abstract class DataProcessor {

    /** 模板方法：定义算法骨架，final 防止子类重写 */
    public final void process() {
        String rawData = readData();
        String parsedData = parseData(rawData);
        saveData(parsedData);
    }

    /** 基本方法：读取原始数据 */
    protected abstract String readData();

    /** 基本方法：解析数据 */
    protected abstract String parseData(String rawData);

    /** 基本方法：保存结果 */
    protected abstract void saveData(String parsedData);
}