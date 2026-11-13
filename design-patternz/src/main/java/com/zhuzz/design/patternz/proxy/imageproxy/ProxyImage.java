package com.zhuzz.design.patternz.proxy.imageproxy;

/**
 * 代理：延迟加载真实图片，首次显示时才创建真实对象
 * Proxy: lazy-loads the real image
 */
public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}