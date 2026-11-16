package com.zhuzz.design.patternz.decorator.datastream;

import com.zhuzz.design.lab.playground.PlaygroundCase;
import com.zhuzz.design.lab.playground.PlaygroundInput;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class DataStreamDemo implements PlaygroundCase {
    @Override public I18nMessages pattern() { return PAT_DECORATOR; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "Data Stream", Locale.SIMPLIFIED_CHINESE, "数据流装饰");
    }
    @Override public List<PlaygroundInput> inputs() {
        return List.of();
    }

    @Override public void run(Map<String, String> values) {
        // 原始文件数据源
        // plain file data source
        DataSource plain = new FileDataSource();
        plain.writeData("Hello");
        System.out.println("Plain read: " + plain.readData());

        // 加密数据源
        // encrypted data source
        DataSource encrypted = new EncryptionDecorator(new FileDataSource());
        encrypted.writeData("Secret");
        System.out.println("Encrypted read: " + encrypted.readData());

        // 压缩 + 加密组合
        // combined compression + encryption
        DataSource combined = new CompressionDecorator(new EncryptionDecorator(new FileDataSource()));
        combined.writeData("Secret");
        System.out.println("Combined read: " + combined.readData());
    }
}