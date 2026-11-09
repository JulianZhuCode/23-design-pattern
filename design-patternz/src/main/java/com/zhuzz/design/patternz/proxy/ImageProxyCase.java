package com.zhuzz.design.patternz.proxy;

/**
 * 代理模式 - 图片代理案例
 *
 * @author zhuzz
 * 2023/8/29 17:43
 */
public class ImageProxyCase {
    public static void main(String[] args) {
        Image image = new ProxyImage("sample.jpg");

        // 图像未加载，直到调用display()方法
        image.display();

        // 图像已加载，无需再次创建
        image.display();
    }

    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadImageFromDisk();
        }

        private void loadImageFromDisk() {
            System.out.println("Loading image from disk: " + filename);
        }

        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    static class ProxyImage implements Image {
        private RealImage realImage;
        private String filename;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }

}