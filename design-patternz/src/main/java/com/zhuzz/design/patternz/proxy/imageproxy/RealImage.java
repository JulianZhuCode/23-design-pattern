package com.zhuzz.design.patternz.proxy.imageproxy;

/** 真实主题：真正加载并显示图片 | Real subject: loads and displays the image */
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}