package com.zhuzz.design.patternz.decorator.datastream;

/**
 * 具体装饰者：压缩
 * Concrete decorator: compression
 */
public class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String compress(String data) {
        return "ZIP(" + data + ")";
    }

    private String decompress(String data) {
        return data.replace("ZIP(", "").replace(")", "");
    }
}