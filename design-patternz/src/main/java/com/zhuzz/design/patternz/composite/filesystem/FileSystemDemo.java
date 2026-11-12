package com.zhuzz.design.patternz.composite.filesystem;

import com.zhuzz.design.lab.DemoCase;
import com.zhuzz.design.lab.i18n.I18nMessages;

import java.util.Locale;
import java.util.Map;

import static com.zhuzz.design.lab.i18n.I18nMessages.*;

public class FileSystemDemo implements DemoCase {
    @Override public I18nMessages pattern() { return PAT_COMPOSITE; }
    @Override public Map<Locale, String> caseNames() {
        return Map.of(Locale.ENGLISH, "File System", Locale.SIMPLIFIED_CHINESE, "文件系统");
    }
    @Override public void run() {
        // 创建文件和文件夹 | create files and folders
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        Directory subDirectory = new Directory("Subdirectory");
        subDirectory.addComponent(file1);
        subDirectory.addComponent(file2);

        Directory rootDirectory = new Directory("Root");
        rootDirectory.addComponent(subDirectory);

        // 展示文件系统结构 | display the structure
        rootDirectory.displayInfo();
    }
}