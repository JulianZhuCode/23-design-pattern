package com.zhuzz.design.patternz.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式 - 文件系统案例
 *
 * @author zhuzz
 * 2023/8/29 17:37
 */
public class FileSystemCase {
    public static void main(String[] args) {
        // 创建文件和文件夹
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        Directory subDirectory = new Directory("Subdirectory");
        subDirectory.addComponent(file1);
        subDirectory.addComponent(file2);

        Directory rootDirectory = new Directory("Root");
        rootDirectory.addComponent(subDirectory);

        // 展示文件系统结构
        rootDirectory.displayInfo();

    }

    interface FileSystemComponent {
        void displayInfo();
    }

    static class File implements FileSystemComponent {
        private String name;

        public File(String name) {
            this.name = name;
        }

        public void displayInfo() {
            System.out.println("File: " + name);
        }
    }

    static class Directory implements FileSystemComponent {
        private String name;
        private List<FileSystemComponent> components;

        public Directory(String name) {
            this.name = name;
            components = new ArrayList<>();
        }

        public void addComponent(FileSystemComponent component) {
            components.add(component);
        }

        public void displayInfo() {
            System.out.println("Directory: " + name);
            for (FileSystemComponent component : components) {
                component.displayInfo();
            }
        }
    }


}