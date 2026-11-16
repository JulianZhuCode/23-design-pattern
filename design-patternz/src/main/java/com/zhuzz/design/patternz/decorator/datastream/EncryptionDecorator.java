package com.zhuzz.design.patternz.decorator.datastream;

/**
 * 具体装饰者：加密
 * Concrete decorator: encryption
 */
public class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {
        super.writeData(encrypt(data));
    }

    @Override
    public String readData() {
        return decrypt(super.readData());
    }

    private String encrypt(String data) {
        return "ENC(" + data + ")";
    }

    private String decrypt(String data) {
        return data.replace("ENC(", "").replace(")", "");
    }
}