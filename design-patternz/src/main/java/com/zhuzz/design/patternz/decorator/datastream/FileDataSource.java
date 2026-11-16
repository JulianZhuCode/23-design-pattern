package com.zhuzz.design.patternz.decorator.datastream;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 具体组件：文件数据源
 * Concrete component: file data source
 */
public class FileDataSource implements DataSource {
    private String data;

    @Override
    public void writeData(String data) {
        this.data = data;
        Messages.println("dataStream.writeRaw", data);
    }

    @Override
    public String readData() {
        return data;
    }
}