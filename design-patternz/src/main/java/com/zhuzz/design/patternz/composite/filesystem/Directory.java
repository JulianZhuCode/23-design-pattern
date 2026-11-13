package com.zhuzz.design.patternz.composite.filesystem;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器节点：目录，可包含文件和子目录
 * Composite: directory holding children
 */
public class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;

    public Directory(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void displayInfo() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.displayInfo();
        }
    }
}