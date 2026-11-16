package com.zhuzz.design.patternz.decorator.datastream;

/**
 * 组件接口：数据源，提供读写
 * Component: data source with read/write
 */
public interface DataSource {
    void writeData(String data);

    String readData();
}