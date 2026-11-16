package com.zhuzz.design.patternz.decorator.datastream;

/**
 * 具体组件：文件数据源
 * Concrete component: file data source
 */
public class FileDataSource implements DataSource {
    private String data;

    @Override
    public void writeData(String data) {
        this.data = data;
        System.out.println("Writing raw data: " + data);
    }

    @Override
    public String readData() {
        return data;
    }
}