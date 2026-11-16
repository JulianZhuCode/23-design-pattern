package com.zhuzz.design.patternz.decorator.datastream;

/**
 * 抽象装饰者：持有被装饰的数据源，默认转发调用
 * Abstract decorator: wraps a data source, forwards by default
 */
public abstract class DataSourceDecorator implements DataSource {
    protected DataSource wrappee;

    public DataSourceDecorator(DataSource wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}