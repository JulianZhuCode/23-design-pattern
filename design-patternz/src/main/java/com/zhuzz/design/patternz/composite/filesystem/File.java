package com.zhuzz.design.patternz.composite.filesystem;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 叶子节点：文件
 * Leaf: file
 */
public class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void displayInfo() {
        Messages.println("filesystem.file", name);
    }
}