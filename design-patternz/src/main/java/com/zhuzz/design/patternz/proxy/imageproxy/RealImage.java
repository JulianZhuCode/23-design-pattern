package com.zhuzz.design.patternz.proxy.imageproxy;

import com.zhuzz.design.lab.i18n.Messages;

/**
 * 真实主题：真正加载并显示图片
 * Real subject: loads and displays the image
 */
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        Messages.println("image.loading", filename);
    }

    @Override
    public void display() {
        Messages.println("image.display", filename);
    }
}